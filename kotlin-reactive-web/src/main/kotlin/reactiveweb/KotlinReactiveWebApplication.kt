package reactiveweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinReactiveWebApplication

fun main(args: Array<String>) {
    runApplication<KotlinReactiveWebApplication>(*args)
}
