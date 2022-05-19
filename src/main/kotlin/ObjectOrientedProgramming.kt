import kotlin.math.PI

fun main() {

    fun run(num: Int) {
        when (num) {
            0 -> { createWithConstructor() }
            1 -> { secondaryConstructor() }
            2 -> { getterSetter() }
            3 -> { inheritance() }
            4 -> { abstract() }
            5 -> { dataClass() }
            6 -> { enumSealed() }
        }
    }
    run(6)

}

sealed class Seal
object SeaLion : Seal()
class Walrus : Seal()


enum class GarbageType1(
    val koName : String
){
    PLASTIC("플라스틱"),
    GLASS("유리"),
    IRON("고철")
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun enumSealed() {

//    fun matchSeal(seal: Seal): String {
//        return when(seal) {
//            is Walrus -> "walrus"
//            is SeaLion -> "sea lion"
//        }
//    }
//    println(matchSeal(SeaLion))
//    println(matchSeal(Walrus()))

    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

    println(GarbageType1.IRON.name)
    println(GarbageType1.PLASTIC.ordinal)
    println(GarbageType1.IRON.ordinal)

    /***
     * Enum의 요소를 차례로 배열로 만들어줍니다
     * array == arrayOf(
     *    GarbageType1.PLASTIC,
     *    GarbageType1.GLASS,
     *    GarbageType1.IRON
     * )
     */
    val array = enumValues<GarbageType1>()

    // iterable이기 때문에 map, filter 등 도 가능합니다.
    array
        .filter { it.koName == "플라스틱" }
        .map { it.koName }

    /***
     * GarbageType1에 PLASTIC 이라는 이름을 가진 요소를 반환합니다.
     * type == GarbageType1.PLASTIC
     */
    val type = enumValueOf<GarbageType1>("PLASTIC")

    tp.execute(array.contentToString())
    tp.execute(type)
}






// data class
fun dataClass() {

    // data class 출력 방식
    val d1 = Decoration("granite")
    println(d1)
    val d2 = Decoration("slate")
    println(d2)
    val d3 = Decoration("slate")
    println(d3)

    // data class 비교
    println (d1.equals(d2))
    println (d3.equals(d2))
    println (d3 === d2 )

    val d4 = Decoration2("crystal", "wood", "diver")
    println(d4)

    // data structure
//    val (rock, _, diver) = d4
    val (a, _, c) = d4
    println(a)
    println(c)
}

data class Decoration(val rocks: String)
data class Decoration2(val rocks: String, val wood: String, val diver: String)





class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

// 단일 클래스
object GoldColor : FishColor {
    override val color = "gold"
}

interface FishAction { fun eat() }
interface FishColor { val color: String }

// eat, color 모두 다른 객체에 delegate
class Plecostomus(fishColor: FishColor = GoldColor): FishColor by fishColor, FishAction by PrintingFishAction("eat plecostomus")

class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}



fun abstract() {
    val tuna = Shark()
    println(tuna.color)
    tuna.eat()

    val dol = Plecostomus()
    println(dol.color)
    dol.eat()
}

//interface FishAct {
//    fun eat()
//}
//
//abstract class Fish() {
//    abstract val color: String
//}
//
//class Tuna: Fish(), FishAct {
//    override val color: String = "blue"
//    override fun eat() {
//        println("Tuna eat")
//    }
//}
//class Dolphin: Fish(), FishAct {
//    override val color: String = "gray"
//    override fun eat() {
//        println("Dolphin eat")
//    }
//}

// 상속
fun inheritance() {
    // 사각 컵 생성
    var building = Aquarium(width = 10, length = 10, height = 20)
    building.print()

    // Aquarium 클래스 상속받는 원형 컵 생성
    val apartment = Apartment(diameter = 10, height = 20)
    apartment.print()

    // apartment getter, setter
    println(apartment.volume)
    apartment.volume = 5000
    apartment.print()
}

/**
 * Aquarium 클래스 상속
 * 원형 빌딩
 * width, length 가 diameter 로 통합
 */
class Apartment (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter ) {
    override var volume: Int
        get() = (diameter * diameter * PI * height).toInt()
        set(value) {
            height = (value / (PI * diameter * diameter)).toInt()
        }
    override var water: Double = volume * 0.8
    override val shape = "cylinder"
}

/**
 * class Aquarium
 * 사각 수족관
 * width, length, height - 가로 세로 높이
 * volume : 총량
 * water : 현재 차있는 물의 양
 * shape : 모양
 */
open class Aquarium(open var length: Int = 20, open var width: Int = 10, open var height: Int = 15) {
    open var volume: Int
        get() = length * width * height
        set(value) {
            height = value / (width * length)
        }
    open val shape = "rect"
    open var water: Double = 0.0
        get() = volume * 0.9

    // fish count에 따라 높이 결정
    constructor(fishCount: Int) : this() {
        println("secondary Constructor")
        val tank = fishCount * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

    // toString()
    fun print() {
        println("-----------------")
        println("width: $width , length: $length , height: $height")
        println("volume: $volume , water: $water , shape: $shape")
    }
}

// getter setter override
fun getterSetter() {
    val aquarium6 = Aquarium(fishCount = 29)
    aquarium6.print()
    aquarium6.volume = 70
    aquarium6.print()
}

// secondaryConstructor 호출
fun secondaryConstructor() {
    val aquarium6 = Aquarium(fishCount = 29)
    aquarium6.print()
}

// 객체 생성
fun createWithConstructor() {
    val ac = Aquarium()
    ac.print()
    ac.height = 60
    ac.print()
    val ac1 = Aquarium()
    ac1.print()
    val ac2 = Aquarium(width = 25)
    ac2.print()
    val ac3 = Aquarium(height = 35, length = 110)
    ac3.print()
}

