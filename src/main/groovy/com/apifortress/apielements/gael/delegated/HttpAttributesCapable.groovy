package com.apifortress.apielements.gael.delegated

import com.apifortress.apielements.gael.Element

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

}