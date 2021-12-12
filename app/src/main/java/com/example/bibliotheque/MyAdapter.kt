package com.example.bibliotheque

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MyAdapter(var myContext: Context, var resource:Int, var items: MutableList<Livres>): ArrayAdapter<Livres>(myContext,resource,items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(myContext)
        val view:View = layoutInflater.inflate(resource,null)

        val lblTitre: TextView = view.findViewById(R.id.lblTitre)
        val lblLocal: TextView = view.findViewById(R.id.lblLocal)
        val imgView: ImageView = view.findViewById(R.id.imgLivre)

        var myItem:Livres = items[position]
        lblTitre.text = myItem._titre
        lblLocal.text = myItem._localisation

        //Permet d'attribuer une image *NE PAS OUBLIER DE METTRE LA PERMISSION D'ACCES A INTERNET DANS LE MANIFESTE
        Glide.with(context).load(items[position]._imgUrl).into(imgView)

        return view
    }






}