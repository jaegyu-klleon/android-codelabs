import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
//    val diceRange = 1..6
//    val tp = TypePrinter()
//    tp.execute(diceRange)
//    println(diceRange)

    val d = Dice(6)
    d.roll()

}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom() {
        if (capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
}

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 6

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }

}

class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2
) : RoundHut(residents, radius) {

    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

}
