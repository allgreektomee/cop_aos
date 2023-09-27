package com.devcation.agtm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.devcation.agtm.databinding.ActivityMainBinding
import com.devcation.agtm.dataModel.user.Login
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.viewModel.MainViewModel


class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var viewModel: MainViewModel
    lateinit var login : Login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        viewModel.getWine(1)
//        viewModel.getWine(2)
//        viewModel.getWine(3)
//        viewModel.getWineDetail(1)

//        login = Login()
//        login.username = "devcation"
//        login.password = "qweasd12!@"
//        viewModel.login(login)

//        viewModel.getWineReviews(1, 1)
//
        viewModel.getUserWineReviews("devcation",1)
        viewModel.getUserClassReviews("devcation",1)
//        viewModel.getAgtmClass()

//        viewModel.getAgtmClassDetail(1)

        binding.button.setOnClickListener {
            viewModel.me()
        }

        binding.signup.setOnClickListener {
            var signup : SignUp
            signup = SignUp()
            signup.email = "test@gmail.com"
            signup.username = "test"
            signup.password ="qwerasdf12"
            signup.password2 ="qwerasdf12"

            viewModel.signup(signup)
        }

    }
}

