package com.apifortress.apielements.gael;

/**
 * The 'messageBody' node. This is not a primitive node but a specialization of Asset
 */
public class MessageBody extends Asset {

    public static String TYPE = 'messageBody'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    public MessageBody(Refract element) {
        super(element);
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    public MessageBody(def object){
        super(object)
    }

    /**
     * Returns the content type of this message body
     * @return the content type
     */
    public String getContentType(){
        return attributes?.contentType
    }

    public String getType(){
        return 'messageBody'
    }
}
