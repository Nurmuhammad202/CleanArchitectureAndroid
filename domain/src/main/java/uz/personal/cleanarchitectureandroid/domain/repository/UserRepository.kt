package uz.personal.cleanarchitectureandroid.domain.repository

import uz.personal.cleanarchitectureandroid.domain.modules.SaveUserNameParam
import uz.personal.cleanarchitectureandroid.domain.modules.sharedModel.ServerDetailModel
import uz.personal.cleanarchitectureandroid.domain.modules.sharedModel.UserName

interface UserRepository {
    fun saveName(saveUserNameParam: SaveUserNameParam): Boolean

    fun getUserData(): UserName

    fun saveServerDetails(serverUrl: String, serverSocket: String): Boolean

    suspend fun getServer(): ServerDetailModel
}