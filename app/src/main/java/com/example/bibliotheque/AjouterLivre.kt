package com.example.bibliotheque

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AjouterLivre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajouter_livre)

        var txtTitre = findViewById<EditText>(R.id.txtTitre)
        val txtAuteur = findViewById<EditText>(R.id.txtAuteur)
        val txtEditeur = findViewById<EditText>(R.id.txtEditeur)
        val txtNbPage = findViewById<EditText>(R.id.txtNbPage)
        val txtPrix = findViewById<EditText>(R.id.txtPrix)
        val txtAnneePub = findViewById<EditText>(R.id.txtAnnePublication)
        val txtLocal = findViewById<EditText>(R.id.txtLocalisation)
        val btnAjouterLivre = findViewById<Button>(R.id.btnAjouterLivre)

        //recuperation des données entrees par l'utilisateur
        val titre = txtTitre.text.toString()
        val auteur = txtAuteur.text.toString()
        val editeur = txtEditeur.text.toString()
        var pages = 0
        try{
            pages = Integer.parseInt(txtNbPage.text.toString())
        }catch (ex:NumberFormatException){
            //Toast.makeText(applicationContext,ex.message, Toast.LENGTH_SHORT).show()
            Log.i("champ","ce champ ne doit pas etre vide")
        }
        var prix = 0.0
        try{
            prix = txtPrix.text.toString().toDouble()
        }catch (ex:NumberFormatException){
            //Toast.makeText(applicationContext,ex.message, Toast.LENGTH_SHORT).show()
            Log.i("champ","ce champ ne doit pas etre vide")
        }
        val annee = txtAnneePub.text.toString()
        val local = txtLocal.text.toString()

        //TODO: regler le probleme avec la variable page et la variable prix
        btnAjouterLivre.setOnClickListener {
                //instancier un livre
                var livre = Livres(txtTitre.text.toString(),txtAuteur.text.toString(),txtEditeur.text.toString(),
                    Integer.parseInt(txtNbPage.text.toString()),txtPrix.text.toString().toDouble(),txtAnneePub.text.toString(),
                    txtLocal.text.toString())

                var db = LivreHelper(applicationContext)
                db.addAll(livre)
        }

    }
}