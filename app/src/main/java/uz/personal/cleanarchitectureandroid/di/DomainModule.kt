package uz.personal.cleanarchitectureandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.personal.cleanarchitectureandroid.domain.repository.UserRepository
import uz.personal.cleanarchitectureandroid.domain.useCase.GetUserNameUserCase
import uz.personal.cleanarchitectureandroid.domain.useCase.SaveUserNameUserCase

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

}