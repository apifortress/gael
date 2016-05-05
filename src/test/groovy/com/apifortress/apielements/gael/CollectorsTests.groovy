package com.apifortress.apielements.gael

import com.apifortress.apielements.gael.collectors.ActionsCollector
import com.apifortress.apielements.gael.collectors.HrefCollector
import com.apifortress.apielements.gael.collectors.HrefVariablesCollector
import groovy.json.JsonSlurper
import org.junit.Before
import org.junit.Test

/**
 *
 */
class CollectorsTests {

    Element element

    @Before
    void setUp(){
        element = new Element(new JsonSlurper().parse((InputStream)getClass().getResourceAsStream('/parsed_elements3.json')))
    }

    @Test
    void variablesCollectorTest(){
        def requests = element.deepFindAll(Element.httpRequestsFilter)
        HrefVariablesCollector collector = new HrefVariablesCollector(requests[1])
        collector.scan()
        assert collector.size() > 0
        collector.each {
            assert it instanceof Member
            assert it.key == 'id'
        }
    }
    @Test
    void endpointsCollectorTest(){
        HrefCollector collector = new HrefCollector(element)
        collector.scan()
        assert collector.size() > 0
        collector.each {
            assert it.startsWith('/')
        }
    }

    @Test
    void actionsCollectorTest(){
        def resourceGroups = element.deepFindAll(Element.resourceGroupsFilter)
        resourceGroups.each{
            it.findAll(Element.resourcesFilter).each { resource ->
                ActionsCollector actionsCollector = new ActionsCollector(resource)
                actionsCollector.scan()
                assert actionsCollector.size() > 0
                actionsCollector.each { action ->
                    assert action.method != null
                    assert action.href != null
                    action.hrefVariablesCollector.each { variable ->
                        assert variable instanceof Member
                    }
                }
            }
        }
    }
}
