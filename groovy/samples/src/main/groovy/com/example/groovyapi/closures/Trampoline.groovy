package com.example.groovyapi.closures

/**
 * Created by bary on 2017-09-24.
 */
class Trampoline {

    static def lastWithTrampoline(def somethingWithSize) {
        def last
        last = { it.size() == 1 ? it.head() : last.trampoline(it.tail()) }
        last = last.trampoline()
        last(somethingWithSize)
    }

    static def lastWithoutTrampoline(def somethingWithSize) {
        def last
        last = { it.size() == 1 ? it.head() : last(it.tail()) }
        last(somethingWithSize)
    }


    static void main(String[] args) {
        println lastWithTrampoline(0..10_000)     // No stack overflow because of tail recursion !
        println lastWithoutTrampoline(0..10_000)  // StackOverflowError
    }
}
