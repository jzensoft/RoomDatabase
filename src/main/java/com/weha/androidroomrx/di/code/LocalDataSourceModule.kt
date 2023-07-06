package com.weha.androidroomrx.di.code

import com.weha.androidroomrx.data.db.UserDao
import com.weha.androidroomrx.data.respository.datasource.UserLocalDataSource
import com.weha.androidroomrx.data.respository.datasourceimpl.UserLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideUserLocalDataSource(userDao: UserDao): UserLocalDataSource {
        return UserLocalDataSourceImpl(userDao)
    }

}