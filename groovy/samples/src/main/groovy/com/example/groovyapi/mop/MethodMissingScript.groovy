package com.example.groovyapi.mop

/**
 * Created by bary on 2017-09-28.
 */
class Pretender {

    def prop = 'a'

    Object getProperty(String property) {
        println "getProperty($property)"
        return getMetaClass().getProperty(this, property);
    }
    void setProperty(String property, Object newValue) {
        println "setProperty($property,$newValue)"
        getMetaClass().setProperty(this, property, newValue);
    }

    Object invokeMethod(String name, Object args) {
        println "invokeMethod($name,$args)"
        return getMetaClass().invokeMethod(this, name, args);
    }

    def propertyMissing(String name) {
        "called property $name"
    }
    def methodMissing(String name, Object arguments) {
        "called method $name with $arguments"
    }

    def existingMethod() {
        "called existing method"
    }
}

def bounce = new Pretender()
println bounce.prop
println bounce.test
println bounce.hello('ala', 'ma', 'kota')
println bounce.existingMethod()

