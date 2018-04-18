package racingcar

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class RacingCarTest : Spek({
    describe("자동차 경주") {
        it("자동차 경주 시작") {
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
    }
})
