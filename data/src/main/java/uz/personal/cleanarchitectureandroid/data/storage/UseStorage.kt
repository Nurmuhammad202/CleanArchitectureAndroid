package uz.personal.cleanarchitectureandroid.data.storage

import uz.personal.cleanarchitectureandroid.data.storage.models.User

interface UseStorage {
    fun save(saveUserNameParam: User): Boolean

    fun get(): User
}