package com.example.groovyapi.closures

/**
 * Created by bary on 2017-09-24.
 */
class Scoping {

    static class Mother {
        def prop = 'prop'
        def method = { 'method' }

        Closure birth(def param) {
            def local = 'local'
            return {
                [this, prop, method(), local, param]
            }
        }
    }

    static void main(String[] args) {

        Mother mother = new Mother()

        def closure = mother.birth('param')
        def context = closure.call()

        assert context[0] == mother
        assert context[1] == 'prop'
        assert context[2] == 'method'
        assert context[3] == 'local'
        assert context[4] == 'param'

        assert closure.thisObject == mother
        assert closure.owner == mother
        assert closure.delegate == mother
        assert closure.resolveStrategy == Closure.OWNER_FIRST


        def closure2 = {
            a = 1
            b = 2
        }
        def map = [:]
        map.with closure2
        assert map == [a:1, b:2]

        assert closure2.thisObject == this
        assert closure2.owner == this
        assert closure2.delegate == this
        assert closure2.resolveStrategy == Closure.OWNER_FIRST

    }
}
