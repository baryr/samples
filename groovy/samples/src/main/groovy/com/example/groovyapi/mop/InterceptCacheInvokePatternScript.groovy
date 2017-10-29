package com.example.groovyapi.mop

ArrayList.metaClass.methodMissing = { String name, Object args ->
    println "invoke methodMissing for $name"
    assert name.startsWith("findBy")
    assert args.size() == 1
    ArrayList.metaClass."$name" = { value ->
        println "invoke $name method"
        delegate.find { it[name.toLowerCase() - "findby"] == value }
    }
    delegate."$name"(args[0])
}

def data = [
        [name:'moon', au: 0.0025],
        [name:'sun', au: 1 ],
        [name:'neptune', au:30 ],
]

println data.findByName('neptune')
println data.findByName('moon')
println data.findByau(1)