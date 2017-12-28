package slipp.web

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
class HtmlControllerTest {
    @Autowired
    lateinit var client: WebTestClient

    @Test
    fun helloworld() {
        client.get().uri("/helloworld")
                .accept(MediaType.TEXT_HTML)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    println(String(it.responseBody))
                }
    }
}