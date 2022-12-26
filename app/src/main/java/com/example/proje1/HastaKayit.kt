package com.example.proje1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proje1.databinding.ActivityHastaKayitBinding
import kotlinx.android.synthetic.main.activity_doktor_kayit.*
import kotlinx.android.synthetic.main.activity_hasta_kayit.*
import kotlinx.android.synthetic.main.activity_main_hasta_giris.*

class HastaKayit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHastaKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

            val context=this
            var db=DatabaseHelperHasta(context)
            binding.btnKaydethasta.setOnClickListener(){

                var etadsoyad=binding.edittextHastakullaniciadi.text.toString()
                var etsifre=binding.edittextHastaSifre.text.toString()
                var ettel=binding.edittextHastaTelNo.text.toString()
                var etyasi=binding.edittextHastaYas.text.toString()
                if(etadsoyad.isNotEmpty()&&etsifre.isNotEmpty()&&ettel.isNotEmpty()&&etyasi.isNotEmpty()){
                    var kullanicihasta=kullanicihasta(etadsoyad,etsifre,ettel.toInt(),etyasi)
                    db.insertData(kullanicihasta)
                    intent=Intent(applicationContext, MainHastaGiris::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(applicationContext,"Lütfen boş alanları doldurun.",Toast.LENGTH_LONG).show()
                            }

            }




        }

    }