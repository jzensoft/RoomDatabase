package com.weha.androidroomrx.domail.usecase

import com.weha.androidroomrx.data.model.User
import com.weha.androidroomrx.domail.repository.UserRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe

class AddUserUseCase(private val repository: UserRepository) {
    fun execute(user: User): Completable {
        return repository.addUser(user)
    }
}