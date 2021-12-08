package com.example.bibliotheque

class Livres {
				private var _id = 0
				private var _titre: String
				private var _auteur: String
				private var _editeur: String
				private var _nbPage: Int
				private var _prix: Double
				private var _anneePub: String
				private var _localisation: String

				constructor(_id: Int,
				            _titre: String,
				            _auteur: String,
				            _editeur: String,
				            _nbPage: Int,
				            _prix: Double,
				            _anneePub: String,
				            _localisation: String) {
								this._id = _id
								this._titre = _titre
								this._auteur = _auteur
								this._editeur = _editeur
								this._nbPage = _nbPage
								this._prix = _prix
								this._anneePub = _anneePub
								this._localisation = _localisation
				}

				constructor(_titre: String,
				            _auteur: String,
				            _editeur: String,
				            _nbPage: Int,
				            _prix: Double,
				            _anneePub: String,
				            _localisation: String) {
								this._titre = _titre
								this._auteur = _auteur
								this._editeur = _editeur
								this._nbPage = _nbPage
								this._prix = _prix
								this._anneePub = _anneePub
								this._localisation = _localisation
				}

				fun get_id(): Int {
								return _id
				}

				fun set_id(_id: Int) {
								this._id = _id
				}

				fun get_titre(): String {
								return _titre
				}

				fun set_titre(_titre: String) {
								this._titre = _titre
				}

				fun get_auteur(): String {
								return _auteur
				}

				fun set_auteur(_auteur: String) {
								this._auteur = _auteur
				}

				fun get_editeur(): String {
								return _editeur
				}

				fun set_editeur(_editeur: String) {
								this._editeur = _editeur
				}

				fun get_nbPage(): Int {
								return _nbPage
				}

				fun set_nbPage(_nbPage: Int) {
								this._nbPage = _nbPage
				}

				fun get_prix(): Double {
								return _prix
				}

				fun set_prix(_prix: Double) {
								this._prix = _prix
				}

				fun get_anneePub(): String {
								return _anneePub
				}

				fun set_anneePub(_anneePub: String) {
								this._anneePub = _anneePub
				}

				fun get_localisation(): String {
								return _localisation
				}

				fun set_localisation(_localisation: String) {
								this._localisation = _localisation
				}
}