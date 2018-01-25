package racingcar

class Car(val name: String, val position: Int = 0) {
    fun move(randomValue: Int): Car {
        if (randomValue > 3) {
            return Car(this.name, this.position + 1)
        }

        return this
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