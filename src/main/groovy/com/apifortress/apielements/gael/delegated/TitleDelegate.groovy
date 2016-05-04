package com.apifortress.apielements.gael.delegated

import com.apifortress.apielements.gael.Element

/**
 *
 */
class TitleDelegate extends Capable implements TitleCapable {

    /**
     * Base constructor
     * @param parentElement the parentElement Element
     */
    TitleDelegate(Element parentElement) {
        super(parentElement)
    }

    @Override
    String getTitle() {
        return parentElement.meta?.title
    }
}
