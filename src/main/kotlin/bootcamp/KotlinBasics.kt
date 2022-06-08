package bootcamp

var tp = TypePrinter();

fun main() {
    fun run(index: Int) {
        when (index) {
            0 -> { operator() }
            1 -> { condition() }
            2 -> { nullable() }
            3 -> { listing() }
            else -> {}
        }
    }

//    run(3)

    play()
}

fun play() {
    val tp = TypePrinter()
    val a = Array<Int>(5) { 0 }
    tp.execute(a)
    val b = IntArray(5) { 0 }
    tp.execute(b)

}

fun listing() {
    val tp = TypePrinter()

    val school = listOf("mackerel", "trout", "halibut")
    tp.execute(school)

    val mList = mutableListOf("tuna", "salmon", "shark")
    tp.execute(mList)
    tp.execute(mList.remove("shark"))
    tp.execute(mList)
    try {
        tp.execute(mList.remove("shark"))
        tp.execute(mList)
    } catch (e: java.lang.Exception) {
        println(e)
    }
    println()

    val school2 = arrayOf("shark", "salmon", "minnow")
    tp.execute(school2)
//    tp.execute(java.util.Arrays.toString(school2))
    tp.execute(school2.contentToString())
    println()

    val mix = arrayOf("fish", 2)
    tp.execute(mix.contentToString())
    val numbers = intArrayOf(1,2,3)
    tp.execute(numbers.toString())
    tp.execute(numbers.contentToString())
    println()

    val numbers2 = intArrayOf(1,2,3)
    val numbers3 = intArrayOf(4,5,6)
    val foo2 = numbers3 + numbers2
    tp.execute(foo2)
    tp.execute(foo2.contentToString())
    tp.execute(foo2[5])
    println()

    val numbers4 = intArrayOf(1, 2, 3)
    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers4, oceans, "salmon")
    tp.execute(oddList)
    println()

    val aaa = arrayOf<Any>("1",1)
    tp.execute(aaa.contentToString())
    tp.execute(aaa[0])
    tp.execute(aaa[1])
    println()

//    val array = Array (5) { it * 2 }
    val array = Array (5) { 0 }
    tp.execute(array)
    tp.execute(array.contentToString())
    println("\n\n")


    val school3 = arrayOf("shark", "salmon", "minnow")
    for (element in school3) {
        print("$element ")
    }
    println()
    for ((index, element) in school.withIndex()) {
        println("index : $index element $element")
    }
    for (i in 1..5) print(i)
    println()
    for (i in 5 downTo 1) print(i)
    println()
    for (i in 3..6 step 2) print(i)
    println()
    for (i in 'd'..'g') print (i)
    println()

    var c = 0
    while (c < 50) {
        c++
    }
    println("$c 1111\n")

    do {
        c--
    } while (c > 50)
    println("$c 2222\n")

    repeat(3) {
        println("repeeeeeat")
    }
}

fun nullable() {
//    var rocks: Int = null
    var nullable1: Int? = null

    var aa = 6
    if (aa != null) {
        aa = aa.dec()
    }

    aa = aa?.dec() ?: 0
    println(aa)

    try {
        val len = nullable1!!.div(1)
    } catch (e: java.lang.Exception) {
        println(e)
    }


}

fun operator() {
    val tp = TypePrinter()
    tp.execute(1+1)
    tp.execute(53-3)
    tp.execute(10/10)
    tp.execute(1.0/2.0)
    tp.execute(2.0*3.5)
    tp.execute(6*50)
    tp.execute(6.0*50.0)
    tp.execute(6.0*50)
    tp.execute(2.times(3))
    tp.execute(3.5.plus(4))
    tp.execute(2.4.div(2))

    val i: Int = 6
    val b1 = i.toByte()
    val b2: Byte = 1
//    val i1: Int = b2
//    val i2: String = b2
//    val i3: Double = b2
    val i4: Int = b2.toInt() // OK!
    tp.execute(i4)

    val i5: String = b2.toString()
    tp.execute(i5)

    val i6: Double = b2.toDouble()
    tp.execute(i6)

    val oneMillion = 1_000_000
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    tp.execute(oneMillion)
    tp.execute(socialSecurityNumber)
    tp.execute(hexBytes)
    tp.execute(bytes)

}

class TypePrinter {
    private var count : Int = 0

    fun execute() {
        println("please insert value")

    }

    fun execute(value: Any) {

//        try {
            println("res$count: (${value.javaClass.kotlin.qualifiedName}) = $value")
//        } catch (e: java.lang.Exception) {
//            println(e)
//        }
        count += 1
    }

    fun execute(valueName: String = "", value: Any) {
        println("res$count: (${value.javaClass.kotlin.qualifiedName}) $valueName = $value")
        count += 1
    }
}

fun condition() {
    val numberOfFish = 50
    val numberOfPlants = 23

    if (numberOfFish > numberOfPlants) {
        println("Good ratio!")
    } else {
        println("Unhealthy ratio")
    }

    val fish = 50
    if (fish in 1..100) {
        println(fish)
    }

    if (numberOfFish == 0) {
        println("Empty tank")
    } else if (numberOfFish < 40) {
        println("Got fish!")
    } else {
        println("That's a lot of fish!")
    }

    when (numberOfFish) {
        0  -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }

}
