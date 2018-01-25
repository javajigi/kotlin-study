package racingcar.view

fun Int.repeat(status: String): String {
    val sb = StringBuilder()
    (0 until this).forEach { sb.append(status) }
    return sb.toString();
}

data class CarView(val name: String, val position: Int) {
    fun matchPosition(maxPosition: Int): Boolean {
        return this.position == maxPosition
    }

    override fun toString(): String {
        return "$name : ${position.repeat("-")}"
    }
}

data class RacingCarView(val cars: List<CarView>) {
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