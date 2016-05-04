package com.apifortress.apielements.gael

/**
 * The 'resource group' node. This is not a primitive node but a specialization of Category
 */
class ResourceGroup extends Category {

    /**
     * Copy constructor
     * @param element a Refract item
     */
    ResourceGroup(Refract element) {
        super(element)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    ResourceGroup(def Object object) {
        super(object)
    }

    public String getType(){
        return 'resourceGroup'
    }
}
