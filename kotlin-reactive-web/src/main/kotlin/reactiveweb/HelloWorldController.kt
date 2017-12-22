package reactiveweb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HelloWorldController() {
    @GetMapping("/helloworld1")
    fun helloworld(): Mono<String> {
        return Mono.just("Hello World")
    }
}