package com.weha.androidroomrx.domail.usecase

import com.weha.androidroomrx.data.model.User
import com.weha.androidroomrx.domail.repository.UserRepository
import io.reactivex.rxjava3.core.Flowable

class GetUserUseCase(private val repository: UserRepository) {
    fun execute(): Flowable<List<User>> {
        return repository.getUsers()
    }
}