package uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain

import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.models.User
import uz.personal.cleanarchitectureandroid.domain.modules.sharedModel.ServerDetailModel

interface UseStorage {
    fun save(saveUserNameParam: User): Boolean

    fun get(): User

    fun saveServer(serverLink: String, serverSocket: String): Boolean

    fun getServer(): ServerDetailModel
}