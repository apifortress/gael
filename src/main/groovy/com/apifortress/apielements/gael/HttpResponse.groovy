package com.apifortress.apielements.gael

/**
 * The 'httpResponse' node
 */
class HttpResponse extends Element{

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

    public String getAttrStatusCode(){
        return attributes?.statusCode
    }

    public List<MessageBody> getMessageBodies(){
        return findAll(Element.messageBodiesFilter)
    }
}
