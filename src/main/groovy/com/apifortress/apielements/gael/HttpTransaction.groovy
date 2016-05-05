package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.delegated.HttpAttributesDelegate

/**
 * The 'httpTransaction' node
 */
class HttpTransaction extends Element {

    public static String TYPE = 'httpTransaction'

    @Delegate
    HttpAttributesDelegate httpDelegate

    /**
     * Copy constructor
     * @param element a Refract item
     */
    HttpTransaction(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    HttpTransaction(def object){
        super(object)
    }

    protected void initDelegates(){
        super.initDelegates()
        httpDelegate = new HttpAttributesDelegate(this)
    }

    /**
     * Shortcut method to retrieve one HttpRequest
     * @return an HttpRequest
     */
    public HttpRequest getHttpRequest(){
        def items = findAll(Element.httpRequestsFilter)
        if(items.size()>0)
            return items[0]
        return null
    }
    /**
     * Shortcut method to retrieve one HttpResponse
     * @return an HttpResponse
     */
    public HttpResponse getHttpResponse(){
        def items = findAll(Element.httpResponsesFilter)
        if(items.size()>0)
            return items[0]
        return null
    }
}
