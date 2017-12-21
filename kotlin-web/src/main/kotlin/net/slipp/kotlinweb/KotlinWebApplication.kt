package net.slipp.kotlinweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinWebApplication

fun main(args: Array<String>) {
    runApplication<KotlinWebApplication>(*args)
}
