package com.apifortress.apielements.gael

/**
 * The 'asset' node
 */
class Asset extends Element implements Specializable {

    public static String TYPE = 'asset'

    /**
     * Copy constructor
     * @param element a Refract item
     */
    Asset(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    Asset(def Object value) {
        super(value)
    }

    @Override
    Specializable specializedInstance() {
        if(meta?.classes?.contains('messageBody'))
            return new MessageBody(this)
        return this
    }
}
