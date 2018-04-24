package lotto.domain

import lotto.view.LottoView

class LottoGame(val buyingMoney: Int) {
    fun match(rawLotto: String, bonusNo: Int): LottoView {
        val lottos = Lottos(listOf());
        val matchingResult = lottos.match(WinningLotto(rawLotto, bonusNo));
        return LottoView(
                matchingResult.matchCountByRank(Rank.FIRST),
                matchingResult.matchCountByRank(Rank.SECOND),
                matchingResult.matchCountByRank(Rank.THIRD),
                matchingResult.matchCountByRank(Rank.FORTH),
                matchingResult.matchCountByRank(Rank.FIFTH),
                matchingResult.getProfit(buyingMoney)
        )
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lottoGame = LottoGame(10000)
            val lottoView = lottoGame.match("1,2,3,4,5,6", 7)
            println("count of first : ${lottoView.firstMatchingCount}")
        }
    }
}