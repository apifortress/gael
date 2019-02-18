package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.delegated.HttpAttributesDelegate;

/**
 * the 'httpRequest' node
 */
public class HttpRequest extends Element {

    public static String TYPE = 'httpRequest'

    @Delegate
    HttpAttributesDelegate httpDelegate
    /**
     * Copy constructor
     * @param element a Refract item
     */
    public HttpRequest(Refract element) {
        super(element);
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    public HttpRequest(def object){
        super(object)
    }

    protected void initDelegates(){
        super.initDelegates()
        httpDelegate = new HttpAttributesDelegate(this)
    }

    /**
     * Returns the 'method' attribute
     * @return the method attribute
     */
    public String getAttrMethod(){
        return getAttribute('method')
    }

    /**
     * Returns the HttpHeaders object
     * @return the HttpHeaders object
     */
    public HttpHeaders getAttrHttpHeaders(){
        return ArtifactFactory.newArtifact(getAttribute('headers'),this)
    }
    /**
     * Returns the message bodies
     * @return the message bodies
     */
    public List<MessageBody> getMessageBodies(){
        return findAll(Element.messageBodiesFilter)
    }

    /**
     * Shortcut to obtain a content type header from the request
     * @return a content type header value or null if not found
     */
    public String getContentTypeHeader(){
        return getAttrHttpHeaders()?.getHeaderValue("Content-Type")
    }
}
