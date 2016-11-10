package com.apifortress.apielements.gael.collectors

import com.apifortress.apielements.gael.Category
import com.apifortress.apielements.gael.Element

/**
 *
 */
class HostCollector implements ICollector{

    Element rootElement

    String value

    public HostCollector(Element rootElement){
        this.rootElement = rootElement
    }

    @Override
    void scan() {
        Category cat = rootElement.findAll(Element.categoriesFilter)[0]
        value = cat?.attrHost
    }
    public String getValue(){
        return value
    }
}
