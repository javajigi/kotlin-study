package slipp.racingcar

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals

class CarSpekTest : Spek({
    describe("자동차 이동 유무") {
        val car = Car("pobi");

        on("랜덤 값이 오늘 날짜이고") {
            it("4이상의 랜덤 값") {
                assertEquals(Car("pobi", 3), car.move(7, 7))
            }

            it("4미만의 랜덤 값") {
                assertEquals(Car("pobi", 2), car.move(3, 3))
            }
        }


        on("랜덤 값이 오늘 날짜가 아니며") {
            it("4이상의 랜덤 값") {
                assertEquals(Car("pobi", 1), car.move(6, 7))
            }

            it("4미만의 랜덤 값") {
                val today = 7;
                assertEquals(Car("pobi", 0), car.move(3, today))
            }
        }
    }
})