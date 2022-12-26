package com.example.proje1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proje1.databinding.ActivityDoktorGirisBinding

class MainDoktorGiris : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoktorGirisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDoktorKayTOl1.setOnClickListener {
            var kullaniciBilgisi = binding.DrSicilGiris.text.toString()
            var kullaniciParola = binding.DrGirisParola.text.toString()
            var sharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor = sharedPreferences.edit()

            //veri ekleme
            editor.putString("kullanici", "$kullaniciBilgisi").apply()
            editor.putString("parola", "$kullaniciParola").apply()
            Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.DrSicilGiris.text.clear()
            binding.DrGirisParola.text.clear()
        }
        binding.btnDoktorKayTOl1.setOnClickListener {
            intent = Intent(applicationContext, DoktorKayit::class.java)
            startActivity(intent)
        }
    }
}