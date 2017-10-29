package com.example.groovyapi.xml

/**
 * Created by bary on 2017-09-17.
 */
class XmlApi {

    String getSampleXml() {
        return """
            <person id="100" >
                <firstname>Jane</firstname>
                <lastname>Doe</lastname>
                <address type="home" >
                    <street>123 Main St</street>
                    <city>Denver</city>
                    <state>CO</state>
                    <zip>80020</zip>
                </address>
                <address type="home2" >
                    <street>321 Main St</street>
                    <city>NY</city>
                    <state>XX</state>
                    <zip>12320</zip>
                </address>
            </person>
            """
    }

    String getSampleXmlWithNamespace() {
        return """
            <p:person xmlns:p="http://somewhere.org/person"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                    xsi:schemaLocation="http://somewhere.org/person http://somewhere.org/person.xsd"
                    id="100" >
                <p:firstname>Jane</p:firstname>
                <p:lastname>Doe</p:lastname>
                <p:address type="home" >
                    <p:street>123 Main St</p:street>
                    <p:city>Denver</p:city>
                    <p:state>CO</p:state>
                    <p:zip>80020</p:zip>
                </p:address>
                <p:address type="home2" >
                    <p:street>321 Main St</p:street>
                    <p:city>NY</p:city>
                    <p:state>XX</p:state>
                    <p:zip>12320</p:zip>
                </p:address>
            </p:person>
            """
    }

    void parseXmlUsingXmlSlurper() {
        def person = new XmlSlurper().parseText(getSampleXml())
        println person
        println person.attributes()
        println person.@id
        println person["@id"]
        // println person.attribute('id')  Not available im XmlSlurper
        println person.firstname
        println person.lastname
        println person.address[0].@type
        println person.address[0].street
        println person.address[0].city
        println person.address[0].state
        println person.address[0].zip
    }

    void parseXmlWithNamespaceUsingXmlSlurper() {
        // Works same as without namespace but you can declare one
        def person = new XmlSlurper().parseText(getSampleXmlWithNamespace())

        def ns = ["p": "http://somewhere.org/person"]
        person.declareNamespace(ns)

        println person
        println person.attributes()
        println person.@id
        println person["@id"]
        // println person.attribute('id')  Not available im XmlSlurper
        println person.firstname
        println person.lastname
        println person.address[0].@type
        println person.address[0].street
        println person.address[0].city
        println person.address[0].state
        println person.address[0].zip      // works normally
        println person.address[0].'p:zip'  // requires person.declareNamespace(ns) in order to work
        println person.address[0]['p:zip'] // requires person.declareNamespace(ns) in order to work
    }

    void parseXmlUsingXmlParser() {
        def person = new XmlParser().parseText(getSampleXml())
        println person
        println person.attributes()
        println person.@id
        println person["@id"]
        println person.attribute('id')
        println person.firstname         // Node
        println person.firstname.text()  // Text of node
        println person.lastname
        println person['lastname'].text()  // HashMap syntax
        println person.address[0].@type
        println person.address.street         // array of nodes
        println person.address.street.text()  // concatenated text
        println person.address[0].street
        println person.address[0].'street'.text()
        println person.address[0].city
        println person.address[0].state
        println person.address[0].zip
    }

    void parseXmlWithNamespaceUsingXmlParser() {
        def person = new XmlParser().parseText(getSampleXmlWithNamespace())
        def p = new groovy.xml.Namespace("http://somewhere.org/person")
        println person
        println person.attributes()
        println person.@id
        println person["@id"]
        println person.attribute('id')
        println person[p.firstname]         // Node
        println person[p.firstname].text()  // Text of node
        println person[p.lastname]
        println person[p.'lastname'].text()  // HashMap syntax
        println person[p.address][0].@type
        println person[p.address][p.street]         // array of nodes
        println person[p.address][p.street].text()  // concatenated text
        println person[p.address][0][p.street]
        println person[p.address][0][p.'street'].text()
        println person[p.address][0][p.city]
        println person[p.address][0][p.state]
        println person[p.address][0][p.zip]
    }


    static void main(String[] args) {
        XmlApi xmlApi = new XmlApi()

        println "------------------------------"
        println "\nParsing XML using XmlSlurper"
        xmlApi.parseXmlUsingXmlSlurper()

        println "------------------------------"
        println "\nParsing XML (with Namespace) using XmlSlurper"
        xmlApi.parseXmlWithNamespaceUsingXmlSlurper()

        println "------------------------------"
        println "\nParsing XML using XmlParser"
        xmlApi.parseXmlUsingXmlParser()

        println "------------------------------"
        println "\nParsing XML (with Namespace) using XmlParser"
        xmlApi.parseXmlWithNamespaceUsingXmlParser()

    }
}

