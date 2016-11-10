package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.delegated.TitleDelegate
/**
 * The 'category' node
 */
class Category extends Element implements Specializable{

    public static String TYPE = 'category'

    @Delegate
    TitleDelegate titleDelegate
    /**
     * Copy constructor
     * @param element a Refract item
     */
    Category(Refract element) {
        super(element)
    }

    protected void initDelegates(){
        super.initDelegates()
        titleDelegate = new TitleDelegate(this)
    }

    /**
     * Default constructor
     * @param value a parsed JSON node representing this Element
     */
    public Category(def object){
        super(object)
    }

    @Override
    Specializable specializedInstance() {
        if(meta?.classes?.contains('resourceGroup'))
            return new ResourceGroup(this)
        return this
    }

    public String getAttrHost(){
        def meta = getAttribute('meta')
        def iterator = meta.iterator()
        while(iterator.hasNext()){
            Member item = ArtifactFactory.newArtifact(iterator.next(),null)
            if(item?.key=='HOST')
                return item.value
        }
        return null
    }
}
