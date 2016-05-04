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
                if(layer1.type=='resourceGroup'){
                    layer1.content().each { layer2 ->
                        assert layer2.type=='resource'||layer2.type=='copy'
                        if(layer2.type=='resource') {
                            assert layer2.getMeta('title') != null
                            assert layer2.getAttribute('href') != null
                            layer2.content().each { layer3 ->
                                assert layer3.type=='transition'||layer3.type=='copy'
                                if(layer3.type=='transition'){
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
            assert it.type=='resourceGroup'&&it.getClass().getSimpleName()=='ResourceGroup'
        }
    }

    @Test
    void deepFindAllTest(){
        def results = element.deepFindAll(Element.httpRequestsFilter)
        assert results.size() > 0
        results.each {
            assert it.type=='httpRequest'
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
