package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.Refract
import com.apifortress.apielements.gael.delegated.HttpAttributesCapable

/**
 * Given a leaf node, it traverses the tree backwards to collect all the HREF variables
 */
class HrefVariablesCollector extends LinkedList implements ICollector {

    /**
     * the leaf element, where the search starts
     */
    Element leafElement

    /**
     * Default constructor
     * @param element the leaf element, where the search starts
     */
    public HrefVariablesCollector(Element element){
        leafElement = element
    }

    public void scan(){
        scan(leafElement)
    }

    /**
     * Recursive scan operation
     * @param element the current element being scanned
     */
    void scan(Element element){
        if(element instanceof HttpAttributesCapable)
            collect(element)
        Element parent = (Element)element.parent
        if (parent != null)
            scan(parent)
    }

    /**
     * The actual collection operation
     * @param element an element that may contain http attributes
     */
    private void collect(HttpAttributesCapable element){
        if(element.hrefVariables) {
            element.hrefVariables.content().each { add(it) }
        }
    }
}
