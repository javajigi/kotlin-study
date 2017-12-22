package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class CarTest: Spek({
    given("a car") {
        val car = Car("javajigi")

        it("move car") {
            assertThat(car.move(4)).isEqualTo(1)
        }

        it ("stay car") {
            assertThat(car.move(3)).isEqualTo(0)
        }

    }
})
