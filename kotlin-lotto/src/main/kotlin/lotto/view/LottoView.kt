package lotto.view

data class LottoView(
        val firstMatchingCount: Int,
        val secondMatchingCount: Int,
        val thirdMatchingCount: Int,
        val forthMatchingCount: Int,
        val fifthMatchingCount: Int,
        val profit: Double) {
}