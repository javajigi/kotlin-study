package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object WinningLottoTest : Spek ({
    describe("당첨번호") {
        val lotto = setOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(lotto, 7)

        it("2등") {
            val userLotto = Lotto(setOf(1, 2, 3, 4, 5, 7))
            val rank = winningLotto.match(userLotto)
            assertThat(rank).isEqualTo(Rank.SECOND)
        }

        it("꽝") {
            val userLotto = Lotto(setOf(1, 2, 7, 8, 9, 10))
            val rank = winningLotto.match(userLotto)
            assertThat(rank).isEqualTo(Rank.NONE)
        }
    }
})