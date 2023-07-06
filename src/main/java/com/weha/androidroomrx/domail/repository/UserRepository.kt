package com.weha.androidroomrx.domail.repository

import com.weha.androidroomrx.data.model.User
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface UserRepository {
    fun getUsers(): Flowable<List<User>>
    fun addUser(user: User): Completable
}