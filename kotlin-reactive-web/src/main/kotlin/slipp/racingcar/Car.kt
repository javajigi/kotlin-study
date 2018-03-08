package slipp.racingcar

class Car(val name: String, val position: Int = 0) {
    fun move(randomValue: Int, today: Int): Car {
        val movePosition = moveToday(randomValue, today) + moveRandomValue(randomValue)
        return Car(this.name, this.position + movePosition)
    }

    private fun moveToday(randomValue: Int, today: Int): Int {
        if (randomValue == today) {
            return 2
        }
        return 0
    }

    private fun moveRandomValue(randomValue: Int): Int {
        if (randomValue > 3) {
            return 1
        }
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }

    override fun toString(): String {
        return "Car(name='$name', position=$position)"
    }
}