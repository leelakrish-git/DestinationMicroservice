package com.example.TaxCalculaterMicroservice2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class TaxCalculaterMicroservice2Application

fun main(args: Array<String>) {
    runApplication<TaxCalculaterMicroservice2Application>(*args)
}
