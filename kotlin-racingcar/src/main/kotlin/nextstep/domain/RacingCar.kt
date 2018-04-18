package nextstep.domain

import nextstep.view.CarView
import nextstep.view.RacingCarView
import java.util.*

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start

fun carRandom() = (0..10).random()

class RacingCar(val cars: List<Car> = listOf()) {
    fun move(tryNo: Int): RacingCarView {
        var movedCars = cars
        (1..tryNo).forEach {
            movedCars = movedCars.map { it.move(carRandom()) }
        }
        return RacingCarView(
                movedCars.map { car -> CarView(car.name, car.position) },
                getWinners(movedCars).map { car -> CarView(car.name, car.position) })
    }

    companion object {
        fun of(names: String): RacingCar {
            return RacingCar(names.split(",").map { Car(it) })
        }

        fun getWinners(cars: List<Car>): List<Car> {
            if (cars.isEmpty()) {
                return cars;
            }
            val maxPosition = cars.maxBy { it.position }!!.position
            return cars.filter { car -> car.matchPosition(maxPosition) }
        }
    }
}
