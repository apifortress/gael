package com.apifortress.apielements.gael.collectors
import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.Refract
import com.apifortress.apielements.gael.Resource
/**
 *
 */
class ActionsCollector extends LinkedList implements ICollector {

    Resource resource

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

    protected scan(ActionItem action,Refract current){
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

    private void handleRequest(ActionItem action,Element current){
        action.method=current.attrMethod
        action.request = current
        action.requestMessageBody = current.findAll(Element.messageBodiesFilter)[0]
        action.hrefVariablesCollector = new HrefVariablesCollector(current)
        action.hrefVariablesCollector.scan()

    }
    private void handleResponse(ActionItem action,Element current){
        action.addResponse(current)
    }
}
