package lotto.domain

enum class Rank(private val matchCount: Int,
                private val winningMoney: Int,
                private val matchBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    fun match(matchCount: Int, matchBonus: Boolean): Boolean {
        return this.matchCount == matchCount && this.matchBonus == matchBonus
    }

    fun winningMoney(countOfMatchLotto: Int): Int {
        return this.winningMoney * countOfMatchLotto
    }

    override fun toString(): String {
        return "Rank(matchCount=$matchCount, matchBonus=$matchBonus)"
    }

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean = false): Rank {
            if (SECOND.match(matchCount, matchBonus)) {
                return SECOND
            }
            return values()
                    .filter { it.match(matchCount, matchBonus) }
                    .firstOrNull() ?: NONE
        }
    }
}