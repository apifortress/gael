package com.apifortress.apielements.gael

import groovy.json.JsonSlurper
import org.junit.Before
import org.junit.Test

/**
 *
 */
class AccessorsTests {

    Element element

    @Before
    void setUp(){
        element = new Element(new JsonSlurper().parse((InputStream)getClass().getResourceAsStream('/parsed_elements3.json')))
    }

    @Test
    void directAccessorsTest(){
        element.content().each { category ->
            assert category.getMeta('title')=='Gist Fox API'
            category.content().each { layer1 ->
                if( layer1.type==ResourceGroup.TYPE ){
                    layer1.content().each { layer2 ->
                        assert layer2.type==Resource.TYPE || layer2.type==Copy.TYPE
                        if(layer2.type==Resource.TYPE) {
                            assert layer2.getMeta('title') != null
                            assert layer2.getAttribute('href') != null
                            layer2.content().each { layer3 ->
                                assert layer3.type==Transition.TYPE || layer3.type==Copy.TYPE
                                if(layer3.type==Transition.TYPE){
                                    assert layer3.getMeta('title') != null
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    void findAllTest(){
        def results = element.content()[0].findAll(Element.resourceGroupsFilter)
        assert results.size() > 0
        results.each {
            assert it.type==ResourceGroup.TYPE &&it.getClass().getSimpleName()=='ResourceGroup'
        }
    }

    @Test
    void deepFindAllTest(){
        def results = element.deepFindAll(Element.httpRequestsFilter)
        assert results.size() > 0
        results.each {
            assert it.type==HttpRequest.TYPE
            assert it.attrMethod in ['GET','POST','PUT','DELETE','PATCH']
        }
    }

    @Test
    void backwardAccessTest(){
        def results = element.deepFindAll(Element.httpRequestsFilter)
        def el = results[0].parent.parent
        assert el.getTitle() == "Retrieve the Entry Point"

    }
}
