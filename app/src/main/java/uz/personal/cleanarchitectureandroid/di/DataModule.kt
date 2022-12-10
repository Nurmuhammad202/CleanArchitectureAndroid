package uz.personal.cleanarchitectureandroid.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.personal.cleanarchitectureandroid.data.remote.ApiInterface
import uz.personal.cleanarchitectureandroid.data.repository.RetrofitRepositoryIml
import uz.personal.cleanarchitectureandroid.data.repository.RoomRepositoryImpl
import uz.personal.cleanarchitectureandroid.data.repository.UserRepositoryImpl
import uz.personal.cleanarchitectureandroid.data.storage.room.RoomDaoInterface
import uz.personal.cleanarchitectureandroid.data.storage.room.appDatabase.AppDatabase
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.UseStorage
import uz.personal.cleanarchitectureandroid.data.storage.sharedPrefMain.sharedPref.SharedPrefUseStorage
import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository
import uz.personal.cleanarchitectureandroid.domain.repository.SmartPhoneRepository
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository
import javax.inject.Singleton

private const val BASE_URL_SERVERS = "http://botmaker.uz:7777/server/"

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofitGetServer(): ApiInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://botmaker.uz:7777/server/")
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitRepository(apiInterface: ApiInterface): RetrofitRepository {
        return RetrofitRepositoryIml(apiInterface = apiInterface)
    }


    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UseStorage {
        return SharedPrefUseStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UseStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

    //room
    @Provides
    @Singleton
    fun provideRoomStorage(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDataDB(context = context)
    }

    @Singleton
    @Provides
    fun getDao(appDB: AppDatabase): RoomDaoInterface {
        return appDB.dao()
    }

    @Singleton
    @Provides
    fun provideRoomRepository(roomDao: RoomDaoInterface): SmartPhoneRepository {
        return RoomRepositoryImpl(roomDao = roomDao)
    }

}