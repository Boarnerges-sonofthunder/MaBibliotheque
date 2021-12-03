package com.example.bibliotheque

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.baoyz.swipemenulistview.SwipeMenuItem

import com.baoyz.swipemenulistview.SwipeMenu

import com.baoyz.swipemenulistview.SwipeMenuCreator
import com.baoyz.swipemenulistview.SwipeMenuListView

//TODO: continuer avec les actions effectué sur la listview
class AfficherLivre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_afficher_livre)
        var listview = findViewById<ListView>(R.id.lstLivre)

        //initialiser une variable avec la classe livreHelper
        val db = LivreHelper(applicationContext)
        //initialiser une variable de type liste et attribuer la function getAllBook pour recuperer tout les livres
        val list: List<Livres> = db.getAllBooks()
        //initialiser une variable et luis attrivuer la classe Myadapter
        var adapter = MyAdapter(this,R.layout.layout_livre,list)
        //appeler la methode setAdapter du listView et lui attriuvuer l'adapter
        listview.setAdapter(adapter)




    }

}


