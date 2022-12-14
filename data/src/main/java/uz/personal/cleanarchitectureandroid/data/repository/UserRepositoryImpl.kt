package uz.personal.cleanarchitectureandroid.data.repository

import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.UseStorage
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.models.ServerDetails
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.models.User
import uz.personal.cleanarchitectureandroid.domain.modules.SaveUserNameParam
import uz.personal.cleanarchitectureandroid.domain.modules.sharedModel.ServerDetailModel
import uz.personal.cleanarchitectureandroid.domain.modules.sharedModel.UserName
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository


class UserRepositoryImpl(private var userStorage: UseStorage) : UserRepository {

    override fun saveName(saveUserNameParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveUserNameParam.name, lastName = "")
        return userStorage.save(user)
    }

    override fun getUserData(): UserName {
        val user = userStorage.get()
        return UserName(name = user.firstName, surname = user.lastName)
    }

    override fun saveServerDetails(serverUrl: String, serverSocket: String): Boolean {
        return userStorage.saveServer(serverLink = serverUrl, serverSocket = serverSocket)
    }

    override suspend fun getServer(): ServerDetailModel {
        val getData = userStorage.getServer()
        return ServerDetailModel(getData.link, getData.socket)
    }


}