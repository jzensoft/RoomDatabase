package com.weha.androidroomrx.data.respository

import com.weha.androidroomrx.data.model.User
import com.weha.androidroomrx.data.respository.datasource.UserLocalDataSource
import com.weha.androidroomrx.domail.repository.UserRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {
    override fun getUsers(): Flowable<List<User>> {
        return userLocalDataSource.getUsers()
    }

    override fun addUser(user: User): Completable {
        return userLocalDataSource.addUser(user)
    }
}