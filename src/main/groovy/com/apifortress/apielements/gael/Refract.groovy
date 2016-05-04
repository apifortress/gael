package com.apifortress.apielements.gael
/**
 * Basic support for the Refract structure
 */
public class Refract {

    /**
     * Parsed value. It can be anything
     */
    def value;

    Refract parent

    /**
     * Copy constructor
     * @param refract a Refract item
     */
    public Refract(Refract refract){
        this.value = refract.value
        initDelegates()
    }
    /**
     * Constructor.
     * @param value a parsed JSON value representing this node
     */
    public Refract(def value){
        this.value = value;
        initDelegates()
    }

    protected void initDelegates(){

    }

    /**
     * Retrieves the content of the node. If it is a base type, such as a String or a number,
     * then it is returned. It returns a Refract node in any other situation
     * @return the content of the node
     */
    public def content(){
        if( !ArtifactFactory.isPrimitiveType(value) && value.containsKey('content')) {
            def c = value.get('content')
            if(ArtifactFactory.isPrimitiveType(c))
                return c
            Refract _parent = this
            if( value instanceof ArrayList )
                _parent = parent
            return ArtifactFactory.newArtifact(c,_parent)
        }
        return value
    }

    /**
     * Iterates in all the child nodes and executes some code at each iteration
     * @param closure a closure to executed at each iteration
     */
    public void each(Closure closure){
        value.each {
            Refract i = ArtifactFactory.newArtifact(it,parent)
            closure(i)
        }
    }
    /**
     * Finds all the child nodes conforming to a specific criteria
     * @param conditions a closure representing a criteria
     * @return a collection of Refract nodes
     */
    public ArrayList<? extends Refract> findAll(Closure conditions){
        def items = new ArrayList<? extends Refract>()
        content().each {
            if(conditions(it))
                items.add(it)
        }
        return items
    }

    /**
     * Depth-scans the tree, collecting all the nodes matching a certain criteria
     * @param conditions a closure representing the criteria
     * @return a collection of Refract nodes
     */
    public List<? extends Refract> deepFindAll(Closure conditions){
        def items = new ArrayList<Refract>()
        deepFindAll(this,conditions,items)
        return items
    }
    /**
     * Inner recursive implementation of deepFindAll
     * @param element current refract element
     * @param conditions a closure representing the criteria
     * @param items the collected items so far
     */
    protected static void deepFindAll(Refract element, Closure conditions,def items){
        def content = element.content()
        if(!ArtifactFactory.isPrimitiveType(content))
            content.each {
                if(conditions(it))
                    items.add(it)
                Refract.deepFindAll(it,conditions,items)
            }
    }

    /**
     * Returns a property with the given name
     * @param prop the name of the property
     * @return the value of the property
     */
    public def get(String prop){
        return value.get(prop)
    }
    /**
     * Returns a value at a given position, when value is a collection
     * @param pos the position
     * @return the retrieved value
     */
    public def getAt(int pos){
        return ArtifactFactory.newArtifact(value.getAt(pos),this)
    }

    /**
     * Returns the value of an 'attribute'
     * @param name the name of the attribute
     * @return the value of the attribute
     */
    public def getAttribute(String name){
        return attributes?."$name"
    }

    /**
     * Returns the value of a 'meta'
     * @param name the name of the meta
     * @return the value of the meta
     */
    public def getMeta(String name){
        return meta?."$name"
    }

    public Refract getParent(){
        return parent
    }

  /*  public String toString(){
        return value.toString()
    }*/
}
