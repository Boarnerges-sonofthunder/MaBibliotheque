package com.example.bibliotheque

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class AfficherLivre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_afficher_livre)
        var listview = findViewById<ListView>(R.id.lstLivre)


        val db = LivreHelper(applicationContext)
        val list: List<Livres> = db.getAllBooks()
        var adapter = MyAdapter(this,R.layout.layout_livre,list)
        listview.setAdapter(adapter)
    }
}