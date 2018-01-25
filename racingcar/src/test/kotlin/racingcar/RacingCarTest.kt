package racingcar

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RacingCarTest {
    @Test
    fun move() {
        val cars = listOf(
                Car("pobi"),
                Car("crong"),
                Car("honux"),
                Car("javajigi"))
        val racing = RacingCar(cars)
        racing.move(5)
    }

    @Test
    fun of() {
        val names = "pobi,crong"
        val cars = RacingCar.of(names)
        assertTrue(cars.size() == 2)
    }
}