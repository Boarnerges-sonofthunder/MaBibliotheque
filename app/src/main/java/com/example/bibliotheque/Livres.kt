package com.example.bibliotheque

open class Livres (var _titre:String, var _auteur:String, var _editeur:String, var _nbPage:Int, var _prix:Double, var _anneePub:String, var _localisation:String) {
    constructor(_id:Int,_titre:String,_auteur:String,_editeur:String,_nbPage:Int,_prix:Double,_anneePub:String,_localisation:String) : this(_titre,_auteur,_editeur,_nbPage,_prix,_anneePub,_localisation)
}