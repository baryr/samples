package com.example.groovyapi.mop

/**
 * Created by bary on 2017-09-28.
 */
class InspectMe {
    int outer() {
        inner()
    }
    private int inner() {
        return 1
    }
}


def tracer = new TracingInterceptor(writer: new StringWriter())
def proxyMetaClass = ProxyMetaClass.getInstance(InspectMe)
proxyMetaClass.interceptor = tracer

def obj = new InspectMe()
obj.metaClass = proxyMetaClass

obj.outer()

println tracer.writer.toString()