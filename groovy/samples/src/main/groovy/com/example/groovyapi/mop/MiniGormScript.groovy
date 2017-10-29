package com.example.groovyapi.mop

/**
 * Created by bary on 2017-09-28.
 */
class MiniGorm {
    def db = []
    def methodMissing(String name, Object args) {
        db.find { it[name - 'findBy'] == args[0] }
    }
}

def people = new MiniGorm()
def john = [First: 'John', Last: 'Smith']
def jack = [First: 'Jack', Last: 'Sparrow', Key: 'test']
people.db << john << jack

println people.findByFirst('Jack')
println people.findByKey('test')

