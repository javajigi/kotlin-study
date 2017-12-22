package slipp.web

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import reactor.core.publisher.Mono

data class Person(val name: String)

@Component
class PersonHandler {
    fun show(req: ServerRequest): Mono<Person> = Mono.just(Person("javajigi"))
}