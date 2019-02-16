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

    public String getHeaderValue(String key){
        String foundValue = null
        content().each {
            if(it!=null && it.getKey()==key)
            foundValue = it.getValue()
        }
        return foundValue
    }
}
