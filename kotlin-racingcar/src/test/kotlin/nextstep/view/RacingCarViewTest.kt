package nextstep.view

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class RacingCarViewTest : Spek ({
    describe("자동차 화면 데이터") {
        it("우승자 문자열") {
            val winnerCars = listOf(
                    CarView("pobi", 3),
                    CarView("crong", 3))
            assertThat(RacingCarView.joinWinners(winnerCars)).isEqualTo("pobi, crong");
        }
    }
})