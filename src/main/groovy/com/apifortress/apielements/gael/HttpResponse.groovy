package com.apifortress.apielements.gael

/**
 * The 'httpResponse' node
 */
class HttpResponse extends Element{

    public static String TYPE = 'httpResponse'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    HttpResponse(Refract value) {
        super(value)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    HttpResponse(def object){
        super(object)
    }

    /**
     * Returns the status code attribute
     * @return the status code attribute
     */
    public String getAttrStatusCode(){
        return attributes?.statusCode
    }

    /**
     * Returns a collection of message bodies
     * @return a collection of message bodies
     */
    public List<MessageBody> getMessageBodies(){
        return findAll(Element.messageBodiesFilter)
    }
}
