package com.example.basicsandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.basicsandroid.databinding.ActivityMainBinding
import com.example.basicsandroid.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = activityMainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.getRandomDog()

        activityMainBinding.randomDog.setOnClickListener {
            mainViewModel.getRandomDog()
        }

        mainViewModel.message.observe(this) {
            Glide.with(this).load(
                it
            ).into(activityMainBinding.imageViewDog)
        }

    }
}