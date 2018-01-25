package racingcar

import racingcar.view.CarView
import racingcar.view.RacingCarView
import java.util.*

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) +  start

fun carRandom() = (0..10).random()

class RacingCar(val cars: List<Car> = listOf()) {
    fun move(tryNo: Int): RacingCarView {
        var movedCars = cars
        (1..tryNo).forEach {
            movedCars = movedCars.map { it.move(carRandom()) }
            println(RacingCarView(movedCars.map { car -> CarView(car.name, car.position) }))
        }
        return RacingCarView(movedCars.map { car -> CarView(car.name, car.position) })
    }

    fun size(): Int {
        return this.cars.size
    }

    companion object {
        fun of(names: String): RacingCar {
            return RacingCar(names.split(",").map { Car(it) })
        }
    }
}
