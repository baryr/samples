package com.example.groovyapi.test

/**
 * Created by bary on 2017-09-27.
 */

class ClassWithProperties {
    def someProperty
    public def someField
    private def somePrivateField

    def getProperty(Object name) {
        println 'get property $name'
    }

    def setProperty(Object name, Object value) {
        println 'set property $name'
    }

    def get(Object name) {
        println 'get $name'
    }

    def set(Object name, Object value) {
        println 'set $name'
    }
}

class Main {
    Map a
    static void main(String[] args) {
        def obj = new ClassWithProperties()
        obj.someField
        obj.someProperty

    }
}

