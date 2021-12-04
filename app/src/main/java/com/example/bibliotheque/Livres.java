package com.example.bibliotheque;

public class Livres {
				private int _id;
				private String _titre;
				private String _auteur;
				private String _editeur;
				private int _nbPage;
				private double _prix;
				private String _anneePub;
				private String _localisation;

				public Livres(int _id, String _titre, String _auteur, String _editeur, int _nbPage, double _prix, String _anneePub, String _localisation) {
								this._id = _id;
								this._titre = _titre;
								this._auteur = _auteur;
								this._editeur = _editeur;
								this._nbPage = _nbPage;
								this._prix = _prix;
								this._anneePub = _anneePub;
								this._localisation = _localisation;
				}

				public Livres(String _titre, String _auteur, String _editeur, int _nbPage, double _prix, String _anneePub, String _localisation) {
								this._titre = _titre;
								this._auteur = _auteur;
								this._editeur = _editeur;
								this._nbPage = _nbPage;
								this._prix = _prix;
								this._anneePub = _anneePub;
								this._localisation = _localisation;
				}

				public int get_id() {
								return _id;
				}

				public void set_id(int _id) {
								this._id = _id;
				}

				public String get_titre() {
								return _titre;
				}

				public void set_titre(String _titre) {
								this._titre = _titre;
				}

				public String get_auteur() {
								return _auteur;
				}

				public void set_auteur(String _auteur) {
								this._auteur = _auteur;
				}

				public String get_editeur() {
								return _editeur;
				}

				public void set_editeur(String _editeur) {
								this._editeur = _editeur;
				}

				public int get_nbPage() {
								return _nbPage;
				}

				public void set_nbPage(int _nbPage) {
								this._nbPage = _nbPage;
				}

				public double get_prix() {
								return _prix;
				}

				public void set_prix(double _prix) {
								this._prix = _prix;
				}

				public String get_anneePub() {
								return _anneePub;
				}

				public void set_anneePub(String _anneePub) {
								this._anneePub = _anneePub;
				}

				public String get_localisation() {
								return _localisation;
				}

				public void set_localisation(String _localisation) {
								this._localisation = _localisation;
				}
}
