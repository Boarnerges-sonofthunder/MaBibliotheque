package com.example.bibliotheque

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter(var myContext: Context, var resource:Int, var items: List<Livres>): ArrayAdapter<Livres>(myContext,resource,items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(myContext)
        val view:View = layoutInflater.inflate(resource,null)

        val lblTitre: TextView = view.findViewById(R.id.lblTitre)
        val lblLocal: TextView = view.findViewById(R.id.lblLocal)

        var myItem:Livres = items[position]
        lblTitre.text = myItem._titre
        lblLocal.text = myItem._localisation

        return view
    }
}