package uz.personal.cleanarchitectureandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.personal.cleanarchitectureandroid.domain.repository.RetrofitRepository
import uz.personal.cleanarchitectureandroid.domain.repository.SmartPhoneRepository
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository
import uz.personal.cleanarchitectureandroid.domain.useCase.*
import uz.personal.cleanarchitectureandroid.domain.useCase.remote.ApiUseCase
import uz.personal.cleanarchitectureandroid.domain.useCase.room.RoomDeleteSmartPhoneUseCase
import uz.personal.cleanarchitectureandroid.domain.useCase.room.RoomGetSmartPhoneUseCase
import uz.personal.cleanarchitectureandroid.domain.useCase.room.RoomSaveSmartPhoneUseCase
import uz.personal.cleanarchitectureandroid.domain.useCase.room.RoomUpdateSmartPhoneUseCase
import uz.personal.cleanarchitectureandroid.domain.useCase.sharedPref.GetUserNameUserCase
import uz.personal.cleanarchitectureandroid.domain.useCase.sharedPref.SaveUserNameUserCase
import uz.personal.cleanarchitectureandroid.domain.useCase.sharedPref.SharedPrefUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideUserNameUseCase(userRepository: UserRepository): SaveUserNameUserCase {
        return SaveUserNameUserCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUserCase {
        return GetUserNameUserCase(userRepository = userRepository)
    }

    @Provides
    fun provideRoomSaveDataUseCase(smartPhoneRepository: SmartPhoneRepository): RoomSaveSmartPhoneUseCase {
        return RoomSaveSmartPhoneUseCase(smartPhoneRepository = smartPhoneRepository)
    }

    @Provides
    fun provideRoomGetDataUseCase(smartPhoneRepository: SmartPhoneRepository): RoomGetSmartPhoneUseCase {
        return RoomGetSmartPhoneUseCase(smartPhoneRepository = smartPhoneRepository)
    }

    @Provides
    fun provideRoomRemove(smartPhoneRepository: SmartPhoneRepository): RoomDeleteSmartPhoneUseCase {
        return RoomDeleteSmartPhoneUseCase(smartPhoneRepository = smartPhoneRepository)
    }

    @Provides
    fun provideRoomUpdate(smartPhoneRepository: SmartPhoneRepository): RoomUpdateSmartPhoneUseCase {
        return RoomUpdateSmartPhoneUseCase(smartPhoneRepository = smartPhoneRepository)
    }

    @Provides
    fun provideRetrofitRepository(retrofitRepository: RetrofitRepository): ApiUseCase {
        return ApiUseCase(retrofitRepository = retrofitRepository)
    }


    @Provides
    fun provideSharedPref(userRepository: UserRepository): SharedPrefUseCase {
        return SharedPrefUseCase(userRepository = userRepository)
    }


}