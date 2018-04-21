package lotto.domain

class MatchingResult {
    private val result = listOf(
            MatchingCountPerLotto(Rank.FIRST),
            MatchingCountPerLotto(Rank.SECOND),
            MatchingCountPerLotto(Rank.THIRD),
            MatchingCountPerLotto(Rank.FORTH),
            MatchingCountPerLotto(Rank.FIFTH))

    fun matchCountByRank(rank: Rank): Int {
        return findMatchingCount(rank)?.matchingCount ?: 0
    }

    fun match(rank: Rank) {
        findMatchingCount(rank)?.match()
    }

    fun findMatchingCount(rank: Rank): MatchingCountPerLotto? {
        return result.filter { it.isMatch(rank) }.firstOrNull()
    }

    class MatchingCountPerLotto(
            private val rank: Rank, var matchingCount: Int = 0) {
        fun isMatch(rank: Rank): Boolean {
            return this.rank == rank;
        }

        fun match(): Int {
            matchingCount++
            return matchingCount
        }
    }
}
