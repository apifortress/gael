package com.apifortress.apielements.gael

/**
 * The 'member' node
 */
class Member extends Element {

    public static String TYPE = 'member'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    Member(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    Member(def Object value) {
        super(value)
    }

    /**
     * @return the key type
     */
    public String getKeyType(){
        return content.key.element
    }
    /**
     * @return the key name
     */
    public String getKey(){
        return content.key.content
    }
    /**
     * @return the value type
     */
    public String getValueType(){
        return content.value.element
    }
    /**
     * @return the value (if available)
     */
    public def getValue(){
        return content.value.content
    }
}
