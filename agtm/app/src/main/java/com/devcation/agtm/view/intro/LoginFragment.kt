package com.devcation.agtm.view.intro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devcation.agtm.common.UserManager
import com.devcation.agtm.dataModel.user.SignIn
import com.devcation.agtm.databinding.FragmentLoginBinding
import com.devcation.agtm.view.main.MainActivity
import com.devcation.agtm.viewModel.UserViewModel


class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: UserViewModel

    lateinit var signInData : SignIn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)



        binding.nextBtn.setOnClickListener {
            val intent = Intent(requireContext(), SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.loginBtn.setOnClickListener{

            signInData = SignIn("devcation", "qweasd12!@")


            viewModel.login(signInData)

            viewModel.liveSign.observe(viewLifecycleOwner, Observer  {
                if( it.ok == "0000") {

                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)



                }
            })
        }
    }

}