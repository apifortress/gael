# GAEL - Groovy API Elements


A parser for [API Elements](https://github.com/apiaryio/api-elements) written in [Groovy](http://www.groovy-lang.org/).

The main aim of GAEL is to simplify the use of API Elements descriptors in your Java/Groovy projects by providing wrappers
with utility accessors and safe query functions, using a versatile extensible structure that allows you to deal with the
variability of the contents.

## Usage
Get started by creating an Element by providing a parsed JSON API Elements document.
As we do in our examples:

	def data = new JsonSlurper().parse((InputStream)getClass().getResourceAsStream('/elements1.json'))
    Element element = new Element(data)

Now you can deep dive into the document by using our methods such as:

	// access the element content
	element.content()

	// finds all the child resources elements. See Element class for more filters
	element.findAll(Element.resourcesFilter)

	// finds all the httpRequest elements in the hierarchy
	element.deepFindAll(Element.httpRequestsFilter)

	/*
	 * iterating over the child elements. If the element is a messageBody, then its class is MessageBody
	 * and therefore implements the getContentType() method
	 */
	element.content().each {
	    if ( it.type == 'messageBody' )
	        println it.contentType
	}

All the query methods may return Elements or specialized classes inheriting from Element.

## TODO
* Write complete reference on the exposed API.
* Extend the collectors functionality
* Implement a more intuitive exception handling