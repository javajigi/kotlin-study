package lotto.domain

class Lottos(private val lottos: List<Lotto>) {
    fun match(winningLotto: WinningLotto): MatchingResult {
        return lottos.fold(MatchingResult()) {
            result, lotto -> result.match(winningLotto.match(lotto))
            return result
        }
    }

}
