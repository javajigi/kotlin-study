package racingcar.view

fun String.repeat(no: Int): String {
    val sb = StringBuilder()
    (0 until no).forEach { sb.append(this) }
    return sb.toString();
}

data class CarView(val name: String, val position: Int) {
    fun matchPosition(maxPosition: Int): Boolean {
        return this.position == maxPosition
    }

    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
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