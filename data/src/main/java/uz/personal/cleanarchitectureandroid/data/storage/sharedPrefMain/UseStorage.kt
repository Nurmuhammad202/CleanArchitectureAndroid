package uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain

import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.models.User

interface UseStorage {
    fun save(saveUserNameParam: User): Boolean

    fun get(): User
}