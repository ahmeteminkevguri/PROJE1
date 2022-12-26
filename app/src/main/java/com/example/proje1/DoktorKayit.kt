package com.example.proje1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proje1.databinding.ActivityDoktorKayitBinding
import com.example.proje1.databinding.ActivityMainHastaGirisBinding

class DoktorKayit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoktorKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnKaydetdr.setOnClickListener {
            var DrBilgisi = binding.edittextDrkullaniciadi.text.toString()
            var DrParola = binding.edittextDrSifre.text.toString()
            var DrTelNo = binding.edittextDrTelNo.text.toString()
            var DrSicilNo= binding.edittextDrSicilno.text.toString()
            var sharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor = sharedPreferences.edit()

            //veri ekleme
            editor.putString("drkullanici", "$DrBilgisi").apply()
            editor.putString("drparola", "$DrParola").apply()
            editor.putString("drtel","$DrTelNo").apply()
            editor.putString("drsicil","$DrSicilNo").apply()
            Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.edittextDrkullaniciadi.text.clear()
            binding.edittextDrSifre.text.clear()
            binding.edittextDrTelNo.text.clear()
            binding.edittextDrSicilno.text.clear()

        }
        binding.btnKaydetdr.setOnClickListener {
            intent = Intent(applicationContext, MainDoktorGiris::class.java)
            startActivity(intent)
        }
    }
}