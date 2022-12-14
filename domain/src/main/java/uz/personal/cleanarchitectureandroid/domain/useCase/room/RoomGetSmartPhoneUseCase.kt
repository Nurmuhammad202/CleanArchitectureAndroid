package uz.personal.cleanarchitectureandroid.domain.useCase.room

import uz.personal.cleanarchitectureandroid.domain.modules.SmartPhoneDomain
import uz.personal.cleanarchitectureandroid.domain.repository.SmartPhoneRepository

class RoomGetSmartPhoneUseCase(private val smartPhoneRepository: SmartPhoneRepository) {
    suspend fun execute(): ArrayList<SmartPhoneDomain> {
        return smartPhoneRepository.readSmartPhone()
    }
}