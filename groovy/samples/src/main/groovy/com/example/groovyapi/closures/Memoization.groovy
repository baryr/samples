package com.example.groovyapi.closures

/**
 * Created by bary on 2017-09-24.
 */
class Memoization {

    static Integer fibWithMemoization(Integer n) {
        def fib
        fib = {it < 2 ? 1 : fib(it-2) + fib(it-1)}
        fib = fib.memoize()
        fib(n)
    }

    static Integer fibWithoutMemoization(Integer n) {
        def fib
        fib = {it < 2 ? 1 : fib(it-2) + fib(it-1)}
        fib(n)
    }


    static void main(String[] args) {
        long start, stop, time1, time2
        start = System.nanoTime()
        println fibWithMemoization(40)           // 165580141
        stop = System.nanoTime()
        time1 = stop - start
        println "Timme with memoization $time1"     // Timme with memoization 80857083

        start = System.nanoTime()
        println fibWithoutMemoization(40)       // 165580141
        stop = System.nanoTime()
        time2 = stop - start
        println "Timme without memoization $time2" // Timme without memoization 16022437871

        println time2/time1 + " slower"            // 198.1575055212 slower

    }

}
