package uz.personal.cleanarchitectureandroid.domain.useCase

import uz.personal.cleanarchitectureandroid.domain.modules.UserName
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository

class GetUserNameUserCase(private var userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getUserData()
    }
}