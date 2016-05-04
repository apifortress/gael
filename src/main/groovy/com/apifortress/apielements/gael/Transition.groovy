package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.delegated.HttpAttributesDelegate
import com.apifortress.apielements.gael.delegated.TitleDelegate

/**
 * The 'transition' node
 */
class Transition extends Element {

    @Delegate
    HttpAttributesDelegate httpDelegate

    @Delegate
    TitleDelegate titleDelegate
    /**
     * Copy constructor
     * @param element a Refract item
     */
    Transition(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    Transition(def Object value) {
        super(value)
    }

    protected void initDelegates(){
        super.initDelegates()
        httpDelegate = new HttpAttributesDelegate(this)
        titleDelegate = new TitleDelegate(this)
    }
}
