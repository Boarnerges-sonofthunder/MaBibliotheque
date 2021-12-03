package com.example.bibliotheque

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAjout = findViewById<Button>(R.id.btnAjouter)
        val btnAffiche = findViewById<Button>(R.id.btnAfficher)
        val btnRecherche = findViewById<Button>(R.id.btnRechercher)

        //declaration des intents
        val ActivAjout = Intent(this,AjouterLivre::class.java)
        val ActivAfficher = Intent(this,AfficherLivre::class.java)
        val ActivRecherche = Intent(this,RechercherLivre::class.java)
        val ActivAfficherRecycl = Intent(this,AfficherLivreRecyleView::class.java)

        btnAjout.setOnClickListener {
            startActivity(ActivAjout)
        }

        btnAffiche.setOnClickListener {
            //startActivity(ActivAfficher)
            startActivity(ActivAfficherRecycl)
        }

        btnRecherche.setOnClickListener {
            startActivity(ActivRecherche)
        }



    }

}