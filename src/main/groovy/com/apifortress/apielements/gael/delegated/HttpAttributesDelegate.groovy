package com.apifortress.apielements.gael.delegated

import com.apifortress.apielements.gael.ArtifactFactory
import com.apifortress.apielements.gael.Element;

/**
 * A httpDelegate class that can be delegated to enrich an object with methods that may contain HTTP related content
 */
class HttpAttributesDelegate extends Capable implements HttpAttributesCapable {

    /**
     * Base constructor
     * @param parentElement the parentElement Element
     */
    public HttpAttributesDelegate(Element parentElement){
        super(parentElement)
    }

    @Override
    public Element getHrefVariables(){
        def vars = parentElement.getAttribute('hrefVariables')
        return ArtifactFactory.newArtifact(vars,parentElement)
    }

    @Override
    public String getAttrHref(){
        return parentElement.getAttribute('href')
    }

}
