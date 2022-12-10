package uz.personal.cleanarchitectureandroid.domain.modules

data class SmartPhoneDomain(var id: Long, var name: String, var price: Double) {
    constructor():this(0L,"",0.0)
}