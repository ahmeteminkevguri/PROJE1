package com.example.proje1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proje1.databinding.ActivityMainHastaGirisBinding
import kotlinx.android.synthetic.main.activity_hasta_kayit.*
import kotlinx.android.synthetic.main.activity_main_hasta_giris.*


class MainHastaGiris : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainHastaGirisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this
        var db = DatabaseHelperHasta(context)

        binding.btnHastaKayitOl1.setOnClickListener() {
            intent = Intent(applicationContext, HastaKayit::class.java)
            startActivity(intent)
        }

        binding.btnHastaGirisYap1.setOnClickListener() {

            var etsifre = binding.kayitParola.text.toString()
            var ettel = binding.kayitTelNo.text.toString()


            if (etsifre.isNotEmpty() && ettel.isNotEmpty() && (edittextHastaTelNo == kayitTelNo) && (edittextHastaSifre == kayitParola)) {
                var kullanicihasta=kullanicihasta(etsifre,ettel.toInt())
                db.insertData(kullanicihasta)


                intent = Intent(applicationContext, Karsilama::class.java)
                startActivity(intent)

            } else if ((edittextHastaTelNo != kayitTelNo) && (edittextHastaSifre != kayitParola)) {
                Toast.makeText(applicationContext, "Giriş Bilgileri Hatalı", Toast.LENGTH_SHORT).show()


            }else
            Toast.makeText(applicationContext, "Lütfen boş alanları doldurun.", Toast.LENGTH_LONG).show()
        }


    }
}







