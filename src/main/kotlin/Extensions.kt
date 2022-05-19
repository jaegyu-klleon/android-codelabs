fun main() {
//    start()
//    pairsTriples()
//    collections()
    extensions()
}


open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

fun extensions() {
//    fun String.hasSpaces(): Boolean {
//        val found = this.find { it == ' ' }
//        return found != null
//    }
    fun String.hasSpaces() = find { it == ' ' } != null
    println("Does it have spaces?".hasSpaces())

    fun AquariumPlant.isRed() = color == "red"    // OK
//    fun AquariumPlant.isBig() = size > 50         // gives error


    fun AquariumPlant.print() = println("AquariumPlant")
    fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?



    fun AquariumPlant?.pull() {
        this?.apply {
            println("removing $this")
        }
    }

    val plant2: AquariumPlant? = null
    plant2.pull()
}



const val rocks = 3

fun constants() {}
val value1 = constants() // OK
// const val CONSTANT1 = constants() // NOT ok

object Constants {
    const val CONSTANT2 = "object constant"
}
val foo = Constants.CONSTANT2

class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}


fun collections() {
    // sum, sumOf 사용법
    val list = listOf(1,5,3,4)
    println(list.sum())
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumOf { it.length })

    // listIterator...??
    for (i in list2.listIterator()) {
        tp.execute(i)
    }
//    tp.execute(list2.listIterator())
//    for (i in list2) {
//        tp.execute(i)
//    }

    // HashMap
    val cures = hashMapOf("key1" to "value1", "key2" to "value2")
    tp.execute(cures)
//    println(cures.get("white spots"))
    println(cures["key1"])
    println(cures.getOrDefault("bloating", "default"))
    println(cures.getOrElse("bloating") {"else"})

    // LinkedHashMap
    val inventory = mutableMapOf("fish net" to 1)
    tp.execute(inventory)
//    inventory.put("tank scrubber", 3)
    inventory["tank scrubber"] = 3
    println(inventory.toString())
    inventory.remove("fish net")
    println(inventory.toString())
}

fun pairsTriples() {
    // 물고기 이름 배열
    val fish = listOf<String>("a", "b", "c", "d")

    // 물고기 이름에 따라 boolean return
    fun isFreshWater(name: String): Boolean {
        return when (name) {
            "a" -> true
            "b" -> true
            "c" -> false
            "d" -> false
            else -> false
        }
    }
    // Pair 객체 반환
    val twoLists = fish.partition { isFreshWater(it) }
    tp.execute(twoLists)
    println("freshwater: ${twoLists.first}")
    println("saltwater: ${twoLists.second}")

    // pair
    val equipment = "front" to "back"
    println("${equipment.first} pair ${equipment.second}")

    // triple
    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    // pair 조작법
    val equipment2 = ("1-1" to "1-2") to "2"
    println("${equipment2.first} is ${equipment2.second}\n")
    println("${equipment2.first.second}")

    // destructure
    val (tool, use) = equipment
    println("$tool is used for $use")
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")
}

// Result는 private한 constructor를 가지고 있음. 내부에서 선언해주어야 함...
sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T): Result<T>()
    data class Failed(val exception: Exception): Result<Nothing>()
    object InProgress: Result<Nothing>()
}

// state
fun start() {
    val result = getResult()
    processResult(result)
}

// 결과에 따라 호출되는 비즈니스 로직 결정
fun processResult(result: Result<String>) {
    when (result) {
        is Result.Success -> println(result.data)
        is Result.Failed -> println(result.exception)
        is Result.InProgress -> println("progressing!")
    }
}

// api 통신 후 결과 반환 함수
fun getResult(): Result<String> {
    return Result.Success("result is success")
//    return Result.Failed(java.lang.Exception("Wow Exception!!"))
}

//sealed class FishType {
//    object Shark: FishType()
//    data class Tuna(val price: Int): FishType()
//}



