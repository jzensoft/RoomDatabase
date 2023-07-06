package com.weha.androidroomrx.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.weha.androidroomrx.data.model.User
import com.weha.androidroomrx.domail.usecase.AddUserUseCase
import com.weha.androidroomrx.domail.usecase.GetUserUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {

    private val TAG = MainViewModel::class.java.simpleName
    private val compositeDisposable = CompositeDisposable()

    private val _isSaved = MutableLiveData<String>()
    val isSaved: LiveData<String> = _isSaved

    private val _users = MutableLiveData<List<User>>()
    val user: LiveData<List<User>> = _users

    init {
        getUsers()
    }

    fun saveUser(fName: String, lName: String) {
        compositeDisposable.add(
            addUserUseCase.execute(User(0, fName, lName))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    _isSaved.value = "Saved"
                }
        )
    }

    private fun getUsers() {
        compositeDisposable.add(
            getUserUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    _users.value = it
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}