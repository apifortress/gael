package com.apifortress.apielements.gael;

/**
 * The 'HrefVariables' node
 */
public class HrefVariables extends Element{

    public static String TYPE = 'hrefVariables'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    public HrefVariables(Refract element) {
        super(element);
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    public HrefVariables(def object){
        super(object)
    }

}
