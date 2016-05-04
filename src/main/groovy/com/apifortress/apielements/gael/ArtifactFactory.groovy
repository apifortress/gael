package com.apifortress.apielements.gael

/**
 * Utility methods helping the hierarchy to produce the right type of node, based on a number
 * of factors
 */
class ArtifactFactory {

    /**
     * The map of all known nodes, discriminateed by the 'element' field
     */
    static def mapping = [ 'category': Category.class,
                    'httpResponse': HttpResponse.class,
                    'httpRequest': HttpRequest.class,
                    'httpTransaction': HttpTransaction.class,
                    'resource': Resource.class,
                    'asset': Asset.class,
                    'copy': Copy.class,
                    'transition': Transition.class,
                    'httpHeaders': HttpHeaders.class,
                    'hrefVariables': HrefVariables.class,
                    'member':Member.class ]

    /**
     * Given an JSON node, a native type or a Refract element, it creates a new artifact
     * of the right type
     * @param item the input object
     * @return the typed artifact
     */
    public static def newArtifact(def item,Refract parentRefract){
        if(item == null)
            return null
        if(isPrimitiveType(item))
            return null
        String element = item.element
        Refract instance
        if(element == null) {
            instance = new Refract(item)
        }else {
            Class mapped = mapping[element]
            if (mapped) {
                instance = mapped.newInstance(item)
                if (instance instanceof Specializable)
                    instance = instance.specializedInstance()
            } else instance = new Refract(item)
        }
        instance.setParent(parentRefract)
        return instance
    }

    /**
     * True when the passed argument is a String or a number
     * @param item the item to be checked
     * @return true if it's a primitive type
     */
    public static boolean isPrimitiveType(def item){
        return item instanceof String || item instanceof Number
    }
}
