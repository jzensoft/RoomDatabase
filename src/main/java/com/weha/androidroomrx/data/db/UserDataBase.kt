package com.weha.androidroomrx.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.weha.androidroomrx.data.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDoa(): UserDao
}