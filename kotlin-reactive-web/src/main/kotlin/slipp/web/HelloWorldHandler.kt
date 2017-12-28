package slipp.web

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class HelloWorldHandler {
    fun helloworld(): Mono<String> {
        return Mono.just("Hello World")
    }

    fun hw(): Mono<String> {
        return Mono.just("Hello World")
    }
}