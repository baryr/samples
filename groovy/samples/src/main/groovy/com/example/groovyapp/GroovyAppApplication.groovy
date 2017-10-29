package com.example.groovyapp

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GroovyAppApplication {

    static void main(String[] args) {
        SpringApplication.run GroovyAppApplication, args
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        { args ->
            String[] beanNames = ctx.getBeanDefinitionNames()
            beanNames.sort()
            println "List of SpringBoot beans:"
            for (beanName in beanNames) {
                println beanName
            }
        }
    }
}
