package lotto.domain

private val LOTTO_SIZE = 6

class Lotto (val lotto: Set<Int>) {
    init {
        if (lotto.size != LOTTO_SIZE) {
            throw IllegalArgumentException()
        }
    }

    constructor(rawLotto: String): this(rawLotto.split(",").map { it.toInt() }.toSet())

    fun match(otherLotto: Lotto): Int {
        return lotto.intersect(otherLotto.lotto).size
    }

    fun matchBonus(bonusNo: Int): Boolean {
        return lotto.contains(bonusNo)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        if (lotto != other.lotto) return false

        return true
    }

    override fun hashCode(): Int {
        return lotto.hashCode()
    }
}