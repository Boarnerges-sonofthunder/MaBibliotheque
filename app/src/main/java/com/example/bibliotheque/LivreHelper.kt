package com.example.bibliotheque

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

val TABLE_LIVRE = "Livre"
val COLUMN_ID = "_id"
val COLUMN_TITRE = "titre"
val COLUMN_AUTEUR = "auteur"
val COLUMN_EDITEUR = "editeur"
val COLUMN_NBPAGE = "nbPage"
val COLUMN_PRIX = "prix"
val COLUMN_ANNEEPUB = "anneePub"
val COLUMN_LOCAL = "localisation"

class LivreHelper(val context : Context) : SQLiteOpenHelper(context,"Bibliotheque.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS " + TABLE_LIVRE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITRE + " TEXT," + COLUMN_AUTEUR + " TEXT," + COLUMN_EDITEUR + " TEXT," +
                COLUMN_NBPAGE + " INTEGER," + COLUMN_PRIX + " INTEGER," + COLUMN_ANNEEPUB + " TEXT," +
                COLUMN_LOCAL + " TEXT)"

        db?.execSQL(sql)
    }

    fun  addAll(livre:Livres)
    {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_TITRE,livre._titre)
        cv.put(COLUMN_AUTEUR,livre._auteur)
        cv.put(COLUMN_EDITEUR,livre._editeur)
        cv.put(COLUMN_NBPAGE,livre._nbPage)
        cv.put(COLUMN_PRIX,livre._prix)
        cv.put(COLUMN_ANNEEPUB,livre._anneePub)
        cv.put(COLUMN_LOCAL,livre._localisation)

        val result = db.insert(TABLE_LIVRE,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"insertion echoué",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"succes",Toast.LENGTH_SHORT).show()


    }

    fun getAllBooks():List<Livres> {
        //TODO:Trouver comment creer une liste et le retourner
        val db: SQLiteDatabase = this.readableDatabase
        val query:String = "SELECT * FROM " + TABLE_LIVRE
        val cur:Cursor = db.rawQuery(query,null)

        //Declaration de la liste et remplissage avec l'objet
        var mutLst = mutableListOf<Livres>()
        var lst = listOf<Livres>()

        if(cur.moveToFirst())
        {
            //iterer dans le cursor,creer un nouveau objet livre et le mettre dans la list
            do {
                var livreId = cur.getInt(0)
                var livreTitre = cur.getString(1)
                var livreAuteur = cur.getString(2)
                var livreEditeur = cur.getString(3)
                var livrePage = cur.getInt(4)
                var livrePrix = cur.getDouble(5)
                var livreAnnee = cur.getString(6)
                var livreLocal = cur.getString(7)

                var livre = Livres(livreId,livreTitre,livreAuteur,livreEditeur,livrePage,livrePrix,livreAnnee,livreLocal)

                //Ajout de l'objet livre dans la liste
                mutLst.add(livre)

            }while (cur.moveToNext())
        }
        else
        {
            Toast.makeText(context,"Il n'y a rien a afficher",Toast.LENGTH_SHORT).show()
        }
        cur.close()
        db.close()
        return mutLst
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}