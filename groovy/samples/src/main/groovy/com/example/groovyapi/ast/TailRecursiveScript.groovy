package com.example.groovyapi.ast

import groovy.transform.TailRecursive

class ListUtil {
    static revers(List list) {
        doReverse(list, [])
    }

    @TailRecursive
    private static doReverse(List list, List done) {
        if (list.isEmpty()) done
        else doReverse(list.tail(), [list.head()] + done)
    }
}

println ListUtil.revers(['1', '2', '3', '4'])

