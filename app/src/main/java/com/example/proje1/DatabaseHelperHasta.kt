package com.example.proje1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val database_name="Veritabanim1"
val table_name="Hastalar"
val col_name="adisoyadi"
val col_password="sifre"
val col_telephone="teli"
val col_age="yasi"
val col_id="id"

class DatabaseHelperHasta(var context: Context):SQLiteOpenHelper(context,
database_name,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var createTable=" CREATE TABLE"+ table_name+"("+
                col_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                col_name+" VARCHAR(256),"+
                col_password+" STRING,"+
                col_telephone+" STRING,"+
                col_age+" INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
    fun insertData(kullanicihasta: kullanicihasta){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(col_name,kullanicihasta.adsoyad)
        cv.put(col_password,kullanicihasta.sifre)
        cv.put(col_telephone,kullanicihasta.tel)
        cv.put(col_age,kullanicihasta.yasi)
        var sonuc= db.insert(table_name,null,cv)
        if(sonuc==(-1).toLong()){
            Toast.makeText(context,"Hatalı",Toast.LENGTH_LONG).show()

        }else {
            Toast.makeText(context, "Başarılı", Toast.LENGTH_LONG).show()
        }
    }
}
