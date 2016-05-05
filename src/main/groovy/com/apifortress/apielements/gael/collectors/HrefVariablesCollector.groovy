package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.Refract
import com.apifortress.apielements.gael.delegated.HttpAttributesCapable

/**
 *
 */
class HrefVariablesCollector extends LinkedList implements ICollector {

    Element leafElement

    public HrefVariablesCollector(Element element){
        leafElement = element
    }

    public void scan(){
        scan(leafElement)
    }

    void scan(Element element){
        if(element instanceof HttpAttributesCapable)
            collect(element)
        Element parent = (Element)element.parent
        if (parent != null)
            scan(parent)
    }

    private void collect(HttpAttributesCapable element){
        if(element.hrefVariables) {
            element.hrefVariables.content().each { add(it) }
        }
    }
}
