package slipp.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
class HWController {
    @GetMapping("/helloworld2")
    fun helloworld(name: String, model: Model): Mono<String> {
        model.addAttribute("name", name)
        return Mono.just("helloworld")
    }
}