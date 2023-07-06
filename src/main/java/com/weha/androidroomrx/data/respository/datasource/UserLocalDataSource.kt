package com.weha.androidroomrx.data.respository.datasource

import com.weha.androidroomrx.data.model.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface UserLocalDataSource {
    fun getUsers(): Flowable<List<User>>
    fun addUser(user: User): Completable
}