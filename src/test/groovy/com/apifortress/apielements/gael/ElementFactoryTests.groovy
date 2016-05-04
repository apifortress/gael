package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.delegated.HttpAttributesCapable
import com.apifortress.apielements.gael.delegated.TitleCapable
import groovy.json.JsonSlurper
import org.junit.Test
/**
 *
 */
class ElementFactoryTests {

    @Test
    void dynamicTypingTest(){
        Element element = new Element(new JsonSlurper().parse((InputStream)getClass().getResourceAsStream('/elements1.json')))
        Element category = element.content()[0]
        assert category.getClass().getSimpleName()=='Category'
        Element resource = category.content()[0]
        assert resource.getClass().getSimpleName()=='Resource'
    }

    @Test
    void specializedTypingTest(){
        Element element = new Element(new JsonSlurper().parse((InputStream)getClass().getResourceAsStream('/parsed_elements3.json')))
        def bodies = element.deepFindAll(Element.messageBodiesFilter)
        assert bodies.size() > 0
        bodies.each {
            assert it.getClass().getSimpleName()=='MessageBody'
        }
    }

    @Test
    void delegationTest(){
        assert Resource.class.getInterfaces().contains(TitleCapable.class)
        assert Resource.class.getInterfaces().contains(HttpAttributesCapable.class)
    }
}
