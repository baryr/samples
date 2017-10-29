package com.example.groovyapi.mop

Number.metaClass {
    getMm = { delegate }
    getCm = { delegate * 10.mm}
    getM  = { delegate * 100.cm}
    getToM   = { delegate / 1000 }
}

def x = 1.m - 5.cm - 1.mm
println x
println x.toM