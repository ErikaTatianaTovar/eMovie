package com.proyecto.emovie.application

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proyecto.emovie.R
import com.proyecto.emovie.databinding.ActivityMainBinding

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        validateVersionSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun validateVersionSplashScreen(){
        if (Build.VERSION.SDK_INT >= 31) {
            installSplashScreen()
        } else {
            setTheme(R.style.Theme_EMovie)
        }
    }
}