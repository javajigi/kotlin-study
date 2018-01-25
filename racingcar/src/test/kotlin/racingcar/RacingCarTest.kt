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
        val racingCarView = racing.move(5)
        println(racingCarView)
        println("${racingCarView.winnersDisplayText()} 가 최종 우승했습니다.")
    }

    @Test
    fun of() {
        val names = "pobi,crong"
        val cars = RacingCar.of(names)
        assertTrue(cars.size() == 2)
    }
}