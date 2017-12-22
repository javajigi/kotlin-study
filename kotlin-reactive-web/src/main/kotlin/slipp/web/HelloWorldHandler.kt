package slipp.web

import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class HelloWorldHandler {
    fun helloworld() : Mono<String> {
        return Mono.just("Hello World")
    }
}