package uz.personal.cleanarchitectureandroid.domain.useCase

import uz.personal.cleanarchitectureandroid.domain.modules.SaveUserNameParam
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository

class SaveUserNameUserCase(private var userRepository: UserRepository) {

    fun execute(saveUserNameParam: SaveUserNameParam): Boolean {
        return userRepository.saveName(saveUserNameParam)
    }

}