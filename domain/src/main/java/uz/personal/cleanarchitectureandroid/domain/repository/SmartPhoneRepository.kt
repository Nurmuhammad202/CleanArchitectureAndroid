package uz.personal.cleanarchitectureandroid.domain.repository

import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain

interface SmartPhoneRepository {

    suspend fun readSmartPhone(): ArrayList<SmartPhoneDomain>

    suspend fun addSmartPhone(smartPhoneDomain: SmartPhoneDomain)

    suspend fun removeSmartPhone(smartPhoneDomain: SmartPhoneDomain)

    suspend fun updateSmartPhone(smartPhoneDomain: SmartPhoneDomain)
}