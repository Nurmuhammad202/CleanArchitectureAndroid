package uz.personal.cleanarchitectureandroid.domain.useCase

import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain
import uz.personal.cleanarchitectureandroid.domain.repository.SmartPhoneRepository

class RoomSaveSmartPhoneUseCase(private var smartPhoneRepository: SmartPhoneRepository) {

    suspend fun execute(smartPhoneDomain: SmartPhoneDomain) {
        smartPhoneRepository.addSmartPhone(smartPhoneDomain)
    }
}