package uz.personal.cleanarchitectureandroid.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.personal.cleanarchitectureandroid.data.repository.UserRepositoryImpl
import uz.personal.cleanarchitectureandroid.data.storage.UseStorage
import uz.personal.cleanarchitectureandroid.data.storage.sharedPref.SharedPrefUseStorage
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

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

}