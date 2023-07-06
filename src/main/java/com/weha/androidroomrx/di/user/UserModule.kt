package com.weha.androidroomrx.di.user

import com.weha.androidroomrx.domail.usecase.AddUserUseCase
import com.weha.androidroomrx.domail.usecase.GetUserUseCase
import com.weha.androidroomrx.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class UserModule {

    @ActivityScoped
    @Provides
    fun provideViewModelFactory(
        getUserUseCase: GetUserUseCase,
        addUserUseCase: AddUserUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(getUserUseCase, addUserUseCase)
    }

}