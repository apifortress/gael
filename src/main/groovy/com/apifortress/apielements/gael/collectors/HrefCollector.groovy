package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.delegated.HttpAttributesCapable

/**
 *
 */
class HrefCollector extends HashSet implements ICollector {

    Element rootElement

    public HrefCollector(Element rootElement){
        this.rootElement = rootElement
    }

    public void scan(){
        def elements = rootElement.deepFindAll {it instanceof HttpAttributesCapable && it.attrHref }
        elements.each {
            add(it.attrHref)
        }
    }

}
