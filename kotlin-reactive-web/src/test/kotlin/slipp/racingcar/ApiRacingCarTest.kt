package slipp.racingcar

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiRacingCarTest {
    @Autowired
    lateinit var client : WebTestClient

    @Test
    fun move_stay() {
        client.get().uri("/api/start?names=보라돌이")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    println("response : ${String(it.responseBody)}")
                    Assertions.assertThat(String(it.responseBody)).contains("보라돌이")
                }
    }

    @Test
    fun move_forward() {
        client.get().uri("/api/start?names=영미")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    println("response : ${String(it.responseBody)}")
                    Assertions.assertThat(String(it.responseBody)).contains("영미")
                }
    }
}