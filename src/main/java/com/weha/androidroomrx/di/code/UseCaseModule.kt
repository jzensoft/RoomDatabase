package com.weha.androidroomrx.di.code

import com.weha.androidroomrx.domail.repository.UserRepository
import com.weha.androidroomrx.domail.usecase.AddUserUseCase
import com.weha.androidroomrx.domail.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideAddUserUseCase(userRepository: UserRepository): AddUserUseCase {
        return AddUserUseCase(userRepository)
    }

}