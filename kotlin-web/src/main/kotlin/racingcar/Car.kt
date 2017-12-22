package racingcar

class Car(val name: String) {
    fun move(num: Int) = if (num > 3) 1 else 0

}