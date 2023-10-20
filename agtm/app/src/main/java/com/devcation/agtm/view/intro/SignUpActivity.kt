package com.devcation.agtm.view.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.dataModel.user.SignUp
import com.devcation.agtm.databinding.ActivitySignupBinding
import com.devcation.agtm.view.main.MainActivity
import com.devcation.agtm.viewModel.UserViewModel

class SignUpActivity : AppCompatActivity() {

    private  lateinit var binding: ActivitySignupBinding
    lateinit var viewModel: UserViewModel
    lateinit var signupData : SignUp
    lateinit var signInData : SignIn
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)




        binding.signup.setOnClickListener {

            signupData = SignUp(
                email = binding.editTextTextEmailAddress.text.toString(),
                username = binding.editTextText2.text.toString(),
                password = binding.editTextTextPassword2.text.toString(),
                password2 = binding.editTextTextPassword3.text.toString())


            viewModel.signup(signupData)

            viewModel.liveSign.observe(this) {
                if( it.ok == "0000") {
                    UserManager.getInstance(this).userName = signupData.username.toString()
                    UserManager.getInstance(this).userPw = signupData.password.toString()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }


}