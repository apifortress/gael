package com.apifortress.apielements.gael

/**
 *
 */
class MessageBodySchema extends Asset {
    public static String TYPE = 'messageBodySchema'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    public MessageBodySchema(Refract element) {
        super(element);
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    public MessageBodySchema(def object){
        super(object)
    }

    public String getType(){
        return 'messageBodySchema'
    }
}
