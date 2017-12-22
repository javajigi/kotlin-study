package slipp.web

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {
    @Autowired
    lateinit var client : WebTestClient

    @Test
    fun helloWorld_annotation() {
        client.get().uri("/helloworld1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .consumeWith {
                    assertThat(String(it.responseBody)).isEqualTo("Hello World")
                }
    }

    @Test
    fun helloWorld_functional() {
        client.get().uri("/helloworld2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    assertThat(String(it.responseBody)).isEqualTo("Hello World")
                }
    }
}