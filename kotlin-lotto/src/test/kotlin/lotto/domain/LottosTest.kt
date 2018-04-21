package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object LottosTest : Spek ({
    describe("여러 장의 로또") {
        it("1등 1장 당첨") {
            val lottos = Lottos(listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12))))
            val winningLotto = WinningLotto(
                    setOf(1, 2, 3, 4, 5, 6), 7)

            val matchingResult = lottos.match(winningLotto)

            assertThat(matchingResult.matchCountByRank(Rank.FIRST)).isEqualTo(1)
            assertThat(matchingResult.matchCountByRank(Rank.SECOND)).isEqualTo(0)
        }
    }
})