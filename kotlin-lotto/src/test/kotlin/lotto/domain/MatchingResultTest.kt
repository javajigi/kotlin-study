package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object MatchingResultTest : Spek ({
    describe("로또 실행 결과") {
        it ("1등에서 5등") {
            val matchingResult = MatchingResult()
            matchingResult.match(Rank.FIRST)
            matchingResult.match(Rank.SECOND)
            matchingResult.match(Rank.THIRD)
            matchingResult.match(Rank.FORTH)
            matchingResult.match(Rank.FIFTH)
            matchingResult.match(Rank.NONE)

            assertThat(matchingResult.matchCountByRank(Rank.FIRST)).isEqualTo(1)
            assertThat(matchingResult.matchCountByRank(Rank.NONE)).isEqualTo(0)
        }
    }
})