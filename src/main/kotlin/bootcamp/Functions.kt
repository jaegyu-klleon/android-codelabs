import bootcamp.tp

val decorations = listOf ("rock", "pagoda", "plastic-plant", "alligator", "flowerpot")

fun main(args: Array<String>) {
//    filterBasic()
//    filterDiff()
//    lazyMapTest()

//    higherOrderFunction()
}


fun higherOrderFunction() {

    var num = 20
    val halfFilter: (Int) -> Int = { it / 2 }
    println(halfFilter(num))


    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter))
}

// filter 사용법, 첫 글자가가 p인 것만
fun filterBasic() {
    tp.execute(decorations.filter { it[0] == 'p' })
}

// sequence
fun filterDiff() {
    val eager = decorations.filter { it [0] == 'p' }
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    val newList = filtered.toList()

    tp.execute("eager", eager)
    tp.execute("filtered", filtered )
    tp.execute("newList", newList )
}

// lazyMap
fun lazyMapTest() {
    val lazyMap = decorations.asSequence().map {
        println("access... $it")
        it
    }
    println("-----")
    tp.execute(lazyMap)
    println("-----")
    lazyMap.first()
    println("-----")
    lazyMap.toList()
    println("-----\n\n")

    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    tp.execute("lazyMap2.toList()", lazyMap2.toList() )

}

