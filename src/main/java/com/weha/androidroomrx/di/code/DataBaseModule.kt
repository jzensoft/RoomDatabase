package com.weha.androidroomrx.di.code

import android.app.Application
import androidx.room.Room
import com.weha.androidroomrx.data.db.UserDao
import com.weha.androidroomrx.data.db.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideUserDataBase(application: Application): UserDataBase {
        return Room.databaseBuilder(application, UserDataBase::class.java, "users").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDataBase: UserDataBase): UserDao {
        return userDataBase.userDoa()
    }

}