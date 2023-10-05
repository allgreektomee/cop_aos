package com.devcation.agtm.view.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.devcation.agtm.databinding.ActivityMainBinding
import com.devcation.agtm.R
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        //        Log.d("MainActivity","onCreate")
        Timber.d("onCreate")
//        Timber.tag("MainActivity").d("onCreate")
//        Timber.tag("MainActivity").e("onCreate")

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.fragmentContainerView4)

        bottomNavigationView.setupWithNavController(navController)
    }
}

