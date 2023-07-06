package com.weha.androidroomrx.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.weha.androidroomrx.data.model.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): Flowable<List<User>>

    @Insert
    fun addUser(user: User): Completable
}