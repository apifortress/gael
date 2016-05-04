package com.apifortress.apielements.gael;

/**
 * Interface for any node that can be specialized based on factors that are not solely
 * the 'element' attribute. It is duty of the main node to implement this
 */
public interface Specializable {

    /**
     * If there are specialization for this node, this method should produce a specialized copy
     * of the current node
     * @return a specialized copy of the current node
     */
    public Specializable specializedInstance();
}
