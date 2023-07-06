package com.weha.androidroomrx.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.weha.androidroomrx.domail.usecase.AddUserUseCase
import com.weha.androidroomrx.domail.usecase.GetUserUseCase

class MainViewModelFactory(
    private val getUserUseCase: GetUserUseCase,
    private val addUserUseCase: AddUserUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserUseCase, addUserUseCase) as T
    }

}