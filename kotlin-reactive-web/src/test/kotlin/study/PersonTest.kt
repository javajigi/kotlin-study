package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PersonTest {
    @Test
    fun getName() {
        val person = Person("javajigi")
        assertThat(person.name).isEqualTo("javajigi")
    }

    @Test
    fun eqauls() {
        assertThat(Person("javajigi")).isEqualTo(Person("javajigi"))
        assertThat(Person("javajigi") == Person("javajigi")).isTrue()
        assertThat(Person("javajigi") === Person("javajigi")).isFalse()
    }
}