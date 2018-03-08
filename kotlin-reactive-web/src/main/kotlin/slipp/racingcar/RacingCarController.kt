package slipp.racingcar

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class RacingCarController {
    @GetMapping("/api/start")
    fun move(names: String): Mono<Result> {
        return Mono.just(Result(Car(names)))
    }
}