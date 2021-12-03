package com.example.bibliotheque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class AfficherLivreRecyleView extends AppCompatActivity {
				private RecyclerView mRecycler;
				private RecyclerView.Adapter mAdapter;
				private RecyclerView.LayoutManager mLayoutManager;
				List<Livres> livre_Liste = new ArrayList<Livres>();

				@Override
				protected void onCreate(Bundle savedInstanceState) {
								super.onCreate(savedInstanceState);
								setContentView(R.layout.activity_afficher_livre_recyle_view);
								LivreHelper db = new LivreHelper(this);
								livre_Liste = db.getAllBooks();
								mRecycler =findViewById(R.id.lst_livre_recycl);

								mRecycler.setHasFixedSize(true);
								mLayoutManager = new LinearLayoutManager(this);
								mRecycler.setLayoutManager(mLayoutManager);
								mAdapter = new RecyclerViewAdapter(livre_Liste,this);
								mRecycler.setAdapter(mAdapter);
				}
}