package com.apifortress.apielements.gael

/**
 * The 'copy' node
 */
class Copy extends Element{

    public static String TYPE = 'copy'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    Copy(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    Copy(def Object value) {
        super(value)
    }

    /**
     * Shortcut for the 'content' method. As 'copy' always returns text, there's no reason to perform
     * further evaluations
     * @return the content of the node
     */
    public String content(){
        return get("content")
    }
}
