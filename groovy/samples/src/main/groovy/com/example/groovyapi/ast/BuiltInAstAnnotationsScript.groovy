package com.example.groovyapi.ast

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.Sortable
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder

class Person {
    String firstName, lastName, addtionalInfo
}

//@Canonical - includes @ToString @EqualsAndHashCode @TupleConstructor
@ToString(includeNames = true, ignoreNulls = true, includePackage=false)
@EqualsAndHashCode
@TupleConstructor
@Sortable(includes = 'firstName, lastName')
@Builder
class PersonWithAst {
    String firstName, lastName, addtionalInfo
}

def person1a = new Person(firstName: 'John', lastName: 'Smith')
def person1b = new Person(firstName: 'John', lastName: 'Smith')
// def person1c = new Person('John', 'Smith', null) // Caught: groovy.lang.GroovyRuntimeException: Could not find matching constructor for: com.example.groovyapi.ast.Person(java.lang.String, java.lang.String, null)
def person2a = new PersonWithAst(firstName: 'John', lastName: 'Smith')
def person2b = new PersonWithAst('John', 'Smith', null)

println person1a.toString() + " equals:" + (person1a == person1b)
println person2a.toString() + " equals:" + (person2a == person2b)

def p1 = new PersonWithAst(firstName: 'Aaa', lastName: 'Ccc')
def p2 = new PersonWithAst(firstName: 'Bbb', lastName: 'Bbb')
def p3 = new PersonWithAst(firstName: 'Ccc', lastName: 'Aaa')

def list = [] << p1 << p2 << p3
println list.toSorted(PersonWithAst.comparatorByLastName())

//p1.metaClass.methods.each { println it}

def person = PersonWithAst.builder().firstName('Chuck').lastName('Norris').build()
println person