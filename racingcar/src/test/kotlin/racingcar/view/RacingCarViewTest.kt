package racingcar.view

import org.junit.Assert
import org.junit.Test
import racingcar.Car
import racingcar.RacingCar

class RacingCarViewTest {
    @Test
    fun getWinners() {
        val cars = listOf(
                CarView("pobi", 8),
                CarView("crong", 7))
        val winnerCars = RacingCarView.getWinners(cars)
        Assert.assertTrue(winnerCars.contains(CarView("pobi", 8)))
    }

    @Test
    fun winnerJoin() {
        val winners = listOf(
                CarView("pobi", 8),
                CarView("crong", 8))
        Assert.assertEquals("pobi, crong", RacingCarView.joinWinners(winners))
    }
}