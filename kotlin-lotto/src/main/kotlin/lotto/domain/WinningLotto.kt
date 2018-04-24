package lotto.domain

class WinningLotto (val lotto: Lotto, val bonusNo: Int) {
    constructor(rawLotto: Set<Int>, bonusNo: Int): this(Lotto(rawLotto), bonusNo)

    constructor(rawLotto: String, bonusNo: Int): this(Lotto(rawLotto), bonusNo)

    fun match(userLotto: Lotto): Rank {
        val matchCount = userLotto.match(lotto)
        val matchBonus = userLotto.matchBonus(bonusNo)
        println("match count : ${matchCount}, matchBonus : ${matchBonus}")
        return Rank.valueOf(matchCount, matchBonus)
    }
}