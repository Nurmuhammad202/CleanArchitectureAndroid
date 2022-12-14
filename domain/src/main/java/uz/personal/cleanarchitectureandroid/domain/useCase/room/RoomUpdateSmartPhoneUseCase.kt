package uz.personal.cleanarchitectureandroid.domain.useCase.room

import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain
import uz.personal.cleanarchitectureandroid.domain.repository.SmartPhoneRepository

class RoomUpdateSmartPhoneUseCase(private val smartPhoneRepository: SmartPhoneRepository) {
    suspend fun execute(smartPhoneDomain: SmartPhoneDomain) {
        smartPhoneRepository.updateSmartPhone(smartPhoneDomain)
    }
}