package com.apifortress.apielements.gael;

/**
 *  By extending the Refract object, Element adds features that are specific to API Elements
 */
public class Element extends Refract{

    /**
     * Copy constructor
     * @param element an Element
     */
    public Element(Element element){
        super(element);
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    Element(def value) {
        super(value)
    }

    /**
     * Criteria for data structures
     */
    static def dataStructuresFilter = {
        it.element=='dataStructure'
    }
    /**
     * Criteria for resources
     */
    static def resourcesFilter = {
        it.element == 'resource'
    }
    /**
     * Criteria for transitions
     */
    static def transitionsFilter = {
        it.element=='transition'
    }
    /**
     * Criteria for copy nodes
     */
    static def copyFilter = {
        it.element=='copy'
    }
    /**
     * Criteria for transactions
     */
    static def httpTransactionsFilter = {
        it.element=='httpTransaction'
    }
    /**
     * Criteria for requests
     */
    static def httpRequestsFilter = {
        it.element=='httpRequest'
    }
    /**
     * Criteria for responses
     */
    static def httpResponsesFilter = {
        it.element=='httpResponse'
    }
    /**
     * Criteria for message bodies
     */
    static def messageBodiesFilter = {
        it.element=='asset' && it.meta.classes.contains('messageBody')
    }
    /**
     * Criteria for body schemas
     */
    static def messageBodySchemasFilter = {
        it.element=='asset' && it.meta.classes.contains('messageBodySchema')
    }
    /**
     * Criteria for categories
     */
    static def categoriesFilter = {
        return it.element == 'category'
    }
    /**
     * Criteria for resource groups
     */
    static def resourceGroupsFilter = {
        return it.element == 'category' && it.meta.classes.contains('resourceGroup')
    }

    /**
     * Returns the 'node type'. The 'element' field if it's possible, the class name in all other situations
     * @return the node type
     */
    public String getType(){
        if(value instanceof Map)
            return value.element
        return value.getClass().getSimpleName()
    }


}
