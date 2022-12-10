package uz.personal.cleanarchitectureandroid.data.storage.room

import androidx.room.*
import uz.personal.cleanarchitectureandroid.data.storage.room.models.SmartPhone

@Dao
interface RoomDaoInterface {

    @Insert
    suspend fun saveData(smartPhone: SmartPhone)

    @Delete
    suspend fun delete(smartPhone: SmartPhone)

    @Update
    suspend fun update(smartPhone: SmartPhone)

    @Query("select * from smart_phone")
    fun read(): List<SmartPhone>
}