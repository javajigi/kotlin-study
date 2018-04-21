package lotto.domain

private val LOTTO_SIZE = 6

class Lotto (val lotto: Set<Int>) {
    init {
        if (lotto.size != LOTTO_SIZE) {
            throw IllegalArgumentException()
        }
    }

    fun match(otherLotto: Lotto): Int {
        return lotto.intersect(otherLotto.lotto).size
    }

    fun matchBonus(bonusNo: Int): Boolean {
        return lotto.contains(bonusNo)
    }
}