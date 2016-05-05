package com.apifortress.apielements.gael.collectors
import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.Refract
import com.apifortress.apielements.gael.Resource
/**
 * Given a Resource element, it goes down to tree to collect all the information that might be
 * necessary to perform an action against an endpoint
 */
class ActionsCollector extends LinkedList implements ICollector {

    /**
     * The root of the operation
     */
    Resource resource

    /**
     * Default constructor
     * @param resource the root of the collection
     */
    public ActionsCollector(Resource resource){
        this.resource = resource
    }
    @Override
    void scan() {
        ActionItem action = new ActionItem()
        action.titles.add(resource.title)
        action.href = resource.attrHref
        resource.content().each {
            scan(action,it)
        }
    }

    /**
     * The recursive scan method
     * @param action the current ActionItem
     * @param current the element currently been searched
     */
    protected void scan(ActionItem action,Refract current){
        switch(current.type){
            case 'transition':
                action = action.clone()
                action.addTitle(current.title)
                action.method=current.attrMethod
                current.content().each {
                    scan(action,it)
                }
                break
            case 'httpTransaction':
                action = action.clone()
                action.addTitle(current.title)
                action.href = current.attrHref
                action.method=current.attrMethod
                current.content().each {
                    if (it.type == 'httpRequest')
                        handleRequest(action,it)
                    if (it.type == 'httpResponse')
                        handleResponse(action,it)
                }
                add(action)
                break
        }
    }

    /**
     * It scans the content of an HttpRequest to fill the ActionItem
     * @param action the ActionItem
     * @param current the element being scanned
     */
    private void handleRequest(ActionItem action,Element current){
        action.method=current.attrMethod
        action.request = current
        action.requestMessageBody = current.findAll(Element.messageBodiesFilter)[0]
        action.hrefVariablesCollector = new HrefVariablesCollector(current)
        action.hrefVariablesCollector.scan()

    }
    /**
     * It scans the content of an HttpResponse to fill the ActionItem
     * @param action the ActionItem
     * @param current the element being scanned
     */
    private void handleResponse(ActionItem action,Element current){
        action.addResponse(current)
    }
}
