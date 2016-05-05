package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.delegated.HttpAttributesCapable

/**
 * Collects all the HREF attributes it can find, by doing a deep search starting from the provided node
 */
class HrefCollector extends HashSet implements ICollector {

    /**
     * The root element
     */
    Element rootElement

    /**
     * Default constructor
     * @param rootElement the root element to start the search from
     */
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
