package lotto.domain

infix fun Int.fdiv(i: Int): Double = this / i.toDouble();

class MatchingResult {
    private val result = mapOf(
            Rank.FIRST to MatchingCountPerLotto(Rank.FIRST),
            Rank.SECOND to MatchingCountPerLotto(Rank.SECOND),
            Rank.THIRD to MatchingCountPerLotto(Rank.THIRD),
            Rank.FORTH to MatchingCountPerLotto(Rank.FORTH),
            Rank.FIFTH to MatchingCountPerLotto(Rank.FIFTH))

    fun matchCountByRank(rank: Rank): Int {
        return findMatchingCount(rank)?.matchingCount ?: 0
    }

    fun match(rank: Rank) {
        findMatchingCount(rank)?.match()
    }

    fun findMatchingCount(rank: Rank): MatchingCountPerLotto? {
        return result.get(rank)
    }

    fun totalWinningMoney(): Int {
        return result.values.map { it.winningMoney() }.sum();
    }

    fun getProfit(investMoney: Int): Double {
        val profit = totalWinningMoney().minus(investMoney);
        return profit.fdiv(investMoney) * 100
    }

    class MatchingCountPerLotto(
            private val rank: Rank, var matchingCount: Int = 0) {
        fun match(): Int {
            matchingCount++
            return matchingCount
        }

        fun winningMoney(): Int {
            return rank.winningMoney(matchingCount)
        }
    }
}
