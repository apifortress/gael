# GAEL - Groovy API Elements


A parser for [API Elements](https://github.com/apiaryio/api-elements) written in [Groovy](http://www.groovy-lang.org/).

The aim of GAEL is to simplify the use of API Elements descriptors in your Java/Groovy projects.
Using a versatile and extensible structure, it provides wrappers with utility accessors and safe query functions that allow you to deal with the variability of the contents.

## Usage
Get started by creating an Element by providing a parsed JSON API Elements document.
As we do in our examples:

	def data = new JsonSlurper().parse((InputStream)getClass().getResourceAsStream('/elements1.json'))
    Element element = new Element(data)

### Querying
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

### Collectors
Collectors are utilities that can simplify some common tasks when consuming API Elements.
Collectors in fact collect interesting items that are spread in the elements tree.

The HrefCollector, searches a provided element and its descendants for 'href' attributes', collecting them
as it finds them.

## TODO
* Write complete reference on the exposed API.
* Extend the collectors functionality
* Implement a more intuitive exception handling