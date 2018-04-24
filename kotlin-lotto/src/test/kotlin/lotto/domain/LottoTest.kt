package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object LottoTest : Spek({
    describe("로또") {
        it("comma로 생성") {
            assertThat(Lotto(setOf(1, 2, 3, 4, 5, 6))).isEqualTo(Lotto("1,2,3,4,5,6"))
        }

        it("유효한 로또") {
            Lotto(setOf(1, 2, 3, 4, 5, 6))
        }

        it("유효하지 않은 로또1") {
            assertThatThrownBy { Lotto(setOf(1, 2, 3, 4, 5)) }
                    .isInstanceOf(IllegalArgumentException::class.java)
        }

        it("유효하지 않은 로또2") {
            assertThatThrownBy { Lotto(setOf(1, 2, 3, 4, 5, 6, 7)) }
                    .isInstanceOf(IllegalArgumentException::class.java)
        }

        it ("match") {
            val winningLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
            val userLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
            assertThat(winningLotto.match(userLotto)).isEqualTo(6);
        }

        it ("matchBonus") {
            val userLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
            assertThat(userLotto.matchBonus(7)).isFalse();
            assertThat(userLotto.matchBonus(6)).isTrue();
        }
    }
})