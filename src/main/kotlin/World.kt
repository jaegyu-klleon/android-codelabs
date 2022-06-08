import kotlinx.coroutines.*

//import kotlinx.coroutines.*
//
//class Monkey(private val name: String) {
//    private val children = mutableListOf<Monkey>()
//
//    fun addChildren(child: Monkey) {
//        children.add(child)
//    }
//
//    infix fun add(that: Monkey) = children.add(that)
//
//    override fun toString(): String {
//        val a: List<String> = children.map { it.name }
//        return "namd: $name, child: ${a} "
//    }
//
//}
//
//fun Monkey.appendMonkey(child: Monkey) = addChildren(child)
//val lambdaAppendMonkey: Monkey.(child: Monkey) -> Unit = { addChildren(it) }
//val anonymousAppendMonkey: Monkey.(child: Monkey) -> Unit = fun Monkey.(child: Monkey) = addChildren(child)
//
//fun main() {
//
//    val parent = Monkey("parent")
//    val child1 = Monkey("child1")
//    val child2 = Monkey("child2")
//    val child3 = Monkey("child3")
//    val child4 = Monkey("child4")
//    val child5 = Monkey("child5")
//    val child6 = Monkey("child6")
//
//    parent.addChildren(child1)
//    parent add child2
//    parent.add(child3)
//    parent.appendMonkey(child4)
//    parent.lambdaAppendMonkey(child5)
//    parent.anonymousAppendMonkey(child6)
//
//    println(parent)
//
//    val c = C(D())
//
//
//}
//
//class D {
//    fun bar() { println("D.bar()") }
//}
//
//class C(d: D) {
//    var d1 = d;
//
//    fun baz() { println("C.bar()") }
//    fun D.foo() {
//        bar()   // calls D.bar
//        baz()   // calls C.baz
//        this@C
//    }
//
//    fun caller(d: D) {
//        d.foo()   // call the extension function
//    }
//
//
//    fun caller1() {
//        d1.foo()
//    }
//}
//

//fun Int.withoutReceiver(block: (it: Int) -> Unit) = block(this)
//

fun main() = runBlocking<Unit> {
    println(Math.random())
//    launch {
//        launch(Dispatchers.IO + CoroutineName("custom1")) {
//            println("launch1: ${Thread.currentThread().name}")
//            println(coroutineContext[CoroutineDispatcher])
//            println(coroutineContext[CoroutineName])
//            delay(5000L)
//         }
//
//        launch(Dispatchers.IO) {
//            println("launch2: ${Thread.currentThread().name}")
//            println(coroutineContext[CoroutineDispatcher])
//            println(coroutineContext[CoroutineName])
//            delay(10L)
//        }
//
//        launch(Dispatchers.IO + CoroutineName("custom2")) {
//            println("launch2: ${Thread.currentThread().name}")
//            println(coroutineContext[CoroutineDispatcher])
//            println(coroutineContext[CoroutineName])
//            delay(10L)
//        }
//    }
}

//data class Length(var centimeters: Int = 0)
//
//var Length.meters: Float
//    get() {
//        return centimeters / 100.0f
//    }
//    set(meters: Float) {
//        this.centimeters = (meters * 100.0f).toInt()
//    }
//
//
//
//
//class Switch(var power: Boolean, val name: String) {
//
//    fun switchPower() {
//        power = !power
//    }
//}
//
//fun main() {
//    val s = Switch(power = false, name = "mire")
//
//    val aa = s.run {
//        println("switch run")
//        switchPower()
//        true
//    }
//
//    println(aa)
//
//}








