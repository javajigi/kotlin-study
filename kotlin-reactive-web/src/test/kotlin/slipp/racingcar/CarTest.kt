package slipp.racingcar

import org.junit.Assert.assertEquals
import org.junit.Test

class CarTest {
    @Test
    fun move_forward() {
        val car = Car("pobi")
        assertEquals(Car("pobi", 1), car.move(4, 7))
    }

    @Test
    fun move_stay() {
        val car = Car("pobi")
        assertEquals(Car("pobi", 0), car.move(3, 7))
    }
}