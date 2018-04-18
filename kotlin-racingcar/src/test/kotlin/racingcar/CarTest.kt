package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class CarTest : Spek({
    describe("자동차") {
        val car = Car("pobi")

        it("Random 값이 4이상인 경우 이동") {
            assertThat(car.move(4))
        }
    }
})