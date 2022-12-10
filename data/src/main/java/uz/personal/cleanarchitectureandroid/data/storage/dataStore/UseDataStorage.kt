package uz.personal.cleanarchitectureandroid.data.storage.dataStore

interface UseDataStorage {
    fun getStorage(stringKey: String): String

    fun saveStorage(stringKey: String, stringItem: String)
}