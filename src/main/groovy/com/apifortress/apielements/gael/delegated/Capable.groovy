package com.apifortress.apielements.gael.delegated

import com.apifortress.apielements.gael.Element

/**
 * Main class of th all the 'capable' classes. All the classes originating from this root in the hierarchy
 * are meant to be delegates inside other classes in the Refract hierarchy
 */
abstract class Capable {
    /**
     * The parentElement Element, that is, the element that delegates methods to this httpDelegate
     */
    protected Element parentElement

    /**
     * Base constructor
     * @param parentElement the parentElement Element
     */
    public Capable(Element parentElement){
        this.parentElement = parentElement
    }
}
