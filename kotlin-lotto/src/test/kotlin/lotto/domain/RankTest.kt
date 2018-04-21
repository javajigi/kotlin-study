package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object RankTest : Spek ({
    describe("로또 등수") {
        it ("1등") {
            assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST)
        }

        it ("2등") {
            assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND)
        }

        it ("3등") {
            assertThat(Rank.valueOf(5)).isEqualTo(Rank.THIRD)
        }

        it ("4등") {
            assertThat(Rank.valueOf(4)).isEqualTo(Rank.FORTH)
        }

        it ("5등") {
            assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH)
        }

        it ("꽝") {
            assertThat(Rank.valueOf(2)).isEqualTo(Rank.NONE)
        }
    }

    describe("수익금") {
        it ("3장의 5등 수익금") {
            val winningMoney = Rank.FIFTH.winningMoney(3)
            assertThat(winningMoney).isEqualTo(15_000)
        }
    }
})