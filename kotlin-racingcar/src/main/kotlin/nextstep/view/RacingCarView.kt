package nextstep.view

infix fun String.repeat(no: Int): String {
    val sb = StringBuilder()
    (0 until no).forEach { sb.append(this) }
    return sb.toString()
}

infix fun String.repeatWith(no: Int): String {
    val that = this;
    return with(StringBuilder()) {
        (0 until no).forEach { append(that) }
        toString()
    }
}

infix fun String.repeatApply(no: Int): String {
    val that = this;
    return StringBuilder().apply {
        (0 until no).forEach { append(that) }
    }.toString()
}

infix fun String.repeatBuildString(no: Int): String {
    val that = this;
    return buildString {
        (0 until no).forEach { append(that) }
    }
}

data class CarView(val name: String, val position: Int) {
    override fun toString(): String {
        return "$name : ${"-".repeatBuildString(position)}"
    }
}

data class RacingCarView(val cars: List<CarView>, val winnerCars: List<CarView>) {
    fun winnersDisplayText(): String {
        return joinWinners(winnerCars)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        cars.forEach {
            sb.append(it.toString())
            sb.append(System.lineSeparator())
        }
        return sb.toString()
    }

    companion object {
        fun joinWinners(winners: List<CarView>): String {
            return winners.map { it.name }.joinToString(", ")
        }
    }
}