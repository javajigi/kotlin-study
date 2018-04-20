package lotto.domain

class Lotto (val lotto: Set<Int>) {
    init {
        if (lotto.size != 6) {
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