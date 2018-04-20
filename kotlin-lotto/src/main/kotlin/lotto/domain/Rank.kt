package lotto.domain

enum class Rank(val matchCount: Int,
                val matchBonus: Boolean = false) {
    FIRST(6),
    SECOND(5, true),
    THIRD(5),
    FORTH(4),
    FIFTH(3),
    NONE(0);

    fun match(matchCount: Int, matchBonus: Boolean): Boolean {
        return this.matchCount == matchCount && this.matchBonus == matchBonus
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