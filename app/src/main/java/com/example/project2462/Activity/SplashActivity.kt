package com.example.project2462.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.project2462.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{
            
startActivity(Intent(this, MainActivity::class.java))
        }

    }
}