package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.delegated.HttpAttributesDelegate
import com.apifortress.apielements.gael.delegated.TitleDelegate
/**
 * The 'resource' node
 */
class Resource extends Element {

    public static String TYPE = 'resource'

    @Delegate
    HttpAttributesDelegate httpDelegate

    @Delegate
    TitleDelegate titleDelegate

    /**
     * Copy constructor
     * @param element a Refract item
     */
    Resource(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    Resource(def Object value) {
        super(value)
    }

    protected void initDelegates(){
        super.initDelegates()
        httpDelegate = new HttpAttributesDelegate(this)
        titleDelegate = new TitleDelegate(this)
    }


}
