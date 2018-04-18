package nextstep.domain

import org.assertj.core.api.Assertions.assertThat
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

        it("우승자") {
            val cars = listOf(
                    Car("pobi", 3),
                    Car("crong", 3),
                    Car("honux", 2),
                    Car("javajigi", 1))
            val winners = RacingCar.getWinners(cars);
            assertThat(winners)
                    .contains(Car("pobi", 3))
                    .contains(Car("crong", 3))
        }
    }
})
