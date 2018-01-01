package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CountingSetTest {
    @Test
    fun size() {
        val cset = CountingSet<Int>()
        cset.addAll(listOf(1, 1, 2))
        assertThat(cset.objectAdded).isEqualTo(3)
    }
}