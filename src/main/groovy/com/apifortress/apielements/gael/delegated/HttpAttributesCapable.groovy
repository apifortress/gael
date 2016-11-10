package com.apifortress.apielements.gael.delegated

import com.apifortress.apielements.gael.Element
import com.apifortress.apielements.gael.HttpHeaders

/**
 * Delegates implementing this interface are able to provide http request attributes
 */
interface HttpAttributesCapable {

    /**
     * @return a HrefVariables object
     */
    Element getHrefVariables()

    /**
     * @return the value of an 'href' attribute
     */
    String getAttrHref()

    HttpHeaders getAttrHttpHeaders()

}