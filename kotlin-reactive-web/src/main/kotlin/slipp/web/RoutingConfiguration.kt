package slipp.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router

@Configuration
class RoutingConfiguration {
    @Bean
    fun routeApiFunction(handler: HelloWorldHandler) : RouterFunction<ServerResponse> = router {
        ("/").nest {
            GET("/api/helloworld2") { req ->
                ServerResponse.ok().body(
                        handler.helloworld()
                )
            }
        }
    }

    @Bean
    fun routeFunction() : RouterFunction<ServerResponse> = router {
        accept(MediaType.TEXT_HTML).nest {
            GET("/helloworld") { ServerResponse.ok().render("helloworld") }
        }
    }

    @Bean
    fun routePerson(handler: PersonHandler): RouterFunction<ServerResponse> = router {
        ("/users").nest {
            GET("/{id}") { req ->
                ServerResponse.ok().body(
                        handler.show(req)
                )
            }
        }
    }
}