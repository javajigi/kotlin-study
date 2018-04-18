package racingcar.view

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
    fun matchPosition(maxPosition: Int): Boolean {
        return this.position == maxPosition
    }

    override fun toString(): String {
        return "$name : ${"-".repeatBuildString(position)}"
    }
}

data class RacingCarView(val cars: List<CarView>) {
    fun winnersDisplayText(): String {
        return joinWinners(getWinners(cars))
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
        fun getWinners(cars: List<CarView>): List<CarView> {
            if (cars.isEmpty()) {
                return cars;
            }
            val maxPosition = cars.maxBy { it.position }!!.position
            return cars.filter { car -> car.matchPosition(maxPosition) }
        }

        fun joinWinners(winners: List<CarView>): String {
            return winners.map { it.name }.joinToString(", ")
        }
    }
}