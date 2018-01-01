package study

import org.assertj.core.api.Assertions.assertThat

import org.junit.Test

class FunctionsTest {
    @Test
    fun lastChar() {
        assertThat("Kotlin".lastChar()).isEqualTo('n')
    }

    @Test
    fun joinString() {
        val list = listOf(1, 2, 3)
        assertThat(list.joinString("; ", "(", ")")).isEqualTo("(1; 2; 3)")
    }

    @Test
    fun join() {
        val list = listOf("one", "two")
        assertThat(list.join(":")).isEqualTo("one:two")
    }
}