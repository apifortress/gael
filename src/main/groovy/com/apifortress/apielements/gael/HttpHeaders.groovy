package com.apifortress.apielements.gael

/**
 * The 'httpHeaders' node
 */
class HttpHeaders extends Element{

    public static String TYPE = 'httpHeaders'
    /**
     * Copy constructor
     * @param element a Refract item
     */
    HttpHeaders(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    HttpHeaders(def Object value) {
        super(value)
    }
}
