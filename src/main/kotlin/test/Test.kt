fun main() {
//    MappingService("name", 123)
//    val obj = Test.create()

//    val user = object {
//        val name :String = "choi"
//
//        fun printMyName() {
//            println(name)
//        }
//    }
//
//    user.printMyName()
//    User.printMyName()
//
//    getNavigation.showNetworkError()

//    val d = Demo()
//    d.run()

    Person().hello()
}

class Person {
    fun hello() { println("hello!") }
}
fun Person.hello() { println("HELLLLLLOOOOOOOOO!!!!") }

//interface 등록
interface Navigation {
    fun showNetworkError()
}

//익명객체 생성
val navigation: Navigation = object : Navigation {
    override fun showNetworkError() {
        println("네트워크 에러 발생")
    }
}

val party = object {
    val name :String = "choi"

    fun printMyName() {
        println("asdf")
    }
}



object User {
    val name :String = "choi"

    fun printMyName() {
        println(name)
    }
}



class Test {
    companion object Factory {
        fun create() : Test = Test()
    }
}


class MappingService(name: String = "asdf") {
    private val firstProperty = name

    init {
        println(name)
        println(firstProperty)
//        println("First initializer block that prints $firstProperty")
    }

    constructor(name: String, age: Int): this(name = name) {
        println("secondary")
    }
}

interface A {
    fun aa() = println("asdfasdfasdf")
    fun aaa()
}

interface AA {
    fun aa() = println("qwerqwerqwer")
}

class B() : A, AA {
    override fun aa() {
        TODO("Not yet implemented")
    }

    override fun aaa() {
        TODO("Not yet implemented")
    }
}
