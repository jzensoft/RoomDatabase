package com.weha.androidroomrx.data.respository.datasourceimpl

import com.weha.androidroomrx.data.db.UserDao
import com.weha.androidroomrx.data.model.User
import com.weha.androidroomrx.data.respository.datasource.UserLocalDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class UserLocalDataSourceImpl(
    private val userDao: UserDao
) : UserLocalDataSource {
    override fun getUsers(): Flowable<List<User>> {
        return userDao.getUsers()
    }

    override fun addUser(user: User): Completable {
        return userDao.addUser(user)
    }
}