package uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.sharedPref

import android.content.Context
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.UseStorage
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.models.ServerDetails
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.models.User

private const val SHARED_PREF_NAME = "SHARED_PREF_KEY"
private const val SHARED_NAME_KEY = "firstName"
private const val SHARED_LAST_KEY = "lastName"
private const val SHARED_DEFAULT_KEY = "Default last name"

private const val SHARED_SERVER_LINK = "SHARED_SERVER_LINK"
private const val SHARED_SERVER_SOCKET = "SHARED_SERVER_SOCKET"

class SharedPrefUseStorage(context: Context) : UseStorage {
    private var sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(saveUserNameParam: User): Boolean {
        sharedPreferences.edit().putString(SHARED_NAME_KEY, saveUserNameParam.firstName).apply()
        return true
    }


    override fun get(): User {
        val firstName = sharedPreferences.getString(SHARED_NAME_KEY, "") ?: ""
        val lastName =
            sharedPreferences.getString(SHARED_LAST_KEY, SHARED_DEFAULT_KEY) ?: SHARED_DEFAULT_KEY
        return User(firstName = firstName, lastName = lastName)
    }

    override fun saveServer(serverLink: String, serverSocket: String): Boolean {
        sharedPreferences.edit().putString(SHARED_SERVER_LINK, serverLink).apply()
        sharedPreferences.edit().putString(SHARED_SERVER_SOCKET, serverSocket).apply()
        return true
    }

    override fun getServer(): ServerDetails {
        val serverLink = sharedPreferences.getString(SHARED_SERVER_LINK, "") ?: ""
        val serverSocket =
            sharedPreferences.getString(SHARED_SERVER_SOCKET, "") ?: ""
        return ServerDetails(serverSocket = serverSocket, serverLink = serverLink)
    }

}