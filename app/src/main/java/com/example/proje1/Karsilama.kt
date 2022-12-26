package com.example.proje1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proje1.databinding.ActivityDoktorKayitBinding
import com.example.proje1.databinding.ActivityKarsilamaBinding
import kotlinx.android.synthetic.main.activity_karsilama.*

class Karsilama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKarsilamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHastaGiris.setOnClickListener {
            intent = Intent(applicationContext, MainHastaGiris::class.java)
            startActivity(intent)
            binding.buttonDrGiris.setOnClickListener {
                intent = Intent(applicationContext, MainDoktorGiris::class.java)
                startActivity(intent)

            }
        }

    }
}


