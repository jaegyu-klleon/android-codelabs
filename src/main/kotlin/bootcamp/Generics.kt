package bootcamp

// 물
open class WaterSupply(var needsProcessing: Boolean)

// 화학처리가 가능한 물 (수돗물)
class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessing = false
    }
}

// 처리가 필요 없는 물 (판매점 물)
class FishStoreWater : WaterSupply(false)

// 필터로 처리가 필요한 물 (호수 물)
class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessing = false
    }
}

// T를 인자로 받는 아쿠아리움
//class Aquarium<T>(val waterSupply: T)

// 윗줄과 동일
// class Aquarium<T: Any?>(val waterSupply: T)

// T에 대하여 non-null 이고 싶을 때
// class Aquarium<T: Any>(val waterSupply: T)

//class Aquarium<out T: WaterSupply>(val waterSupply: T) {
//    fun addWater() {
//        // cheak(param): 파라미터 값이 false 일 경우 throw error
//        check(!waterSupply.needsProcessing) { "water supply needs processing first" }
//        println("adding water from $waterSupply")
//    }
//}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessing) {
            cleaner.clean(waterSupply)
        }
        println("water added")
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) =   waterSupply.addChemicalCleaners()
}


fun genericsExample() {
//    val aquarium = Aquarium(TapWater())
//    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
//    aquarium.waterSupply.addChemicalCleaners()
//    println("water needs processing: ${aquarium.waterSupply.needsProcessing}")
//
////    val aquarium2 = Aquarium("string")
////    println(aquarium2.waterSupply)
////
////    val aquarium3 = Aquarium(null)
////    if (aquarium3.waterSupply == null) {
////        println("waterSupply is null")
////    }
//
//    val aquarium4 = Aquarium(LakeWater())
//    aquarium4.waterSupply.filter()
//    aquarium4.addWater()

//    val aquarium = Aquarium(TapWater())
//    addItemTo(aquarium)

    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    aquarium.addWater(cleaner)
}

fun main() {
    genericsExample()
}
