package com.weha.androidroomrx.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.weha.androidroomrx.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        initUserAdapter()
        initListener()
        subscribe()
    }

    private fun initUserAdapter() {
        userAdapter = UserAdapter()
        binding.rvUser.apply {
            adapter = userAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initListener() {
        binding.btnSave.setOnClickListener {
            val name = binding.edtUser.text.toString()
            if (name.isNotEmpty()) {
                binding.edtUser.setText("")
                viewModel.saveUser(name, "")
            }
        }
    }

    private fun subscribe() {
        viewModel.isSaved.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        viewModel.user.observe(this) {
            userAdapter.setData(it)
            binding.rvUser.smoothScrollToPosition(it.size)
        }
    }
}