package com.weha.androidroomrx.di.code

import com.weha.androidroomrx.data.respository.UserRepositoryImpl
import com.weha.androidroomrx.data.respository.datasource.UserLocalDataSource
import com.weha.androidroomrx.domail.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userLocalDataSource: UserLocalDataSource): UserRepository {
        return UserRepositoryImpl(userLocalDataSource)
    }

}