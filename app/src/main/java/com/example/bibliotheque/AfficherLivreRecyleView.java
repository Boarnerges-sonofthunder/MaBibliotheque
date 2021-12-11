package com.example.bibliotheque;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class AfficherLivreRecyleView extends AppCompatActivity implements RecyclerItemTouchHelperListener {
				private RecyclerView mRecycler;
				private RecyclerView.Adapter mAdapter;
				private RecyclerView.LayoutManager mLayoutManager;
				private RecyclerViewAdapter adapter;
				private LinearLayout rootLayout;
				List<Livres> livre_Liste = new ArrayList<Livres>();

				@Override
				protected void onCreate(Bundle savedInstanceState) {
								super.onCreate(savedInstanceState);
								setContentView(R.layout.activity_afficher_livre_recyle_view);

								LivreHelper db = new LivreHelper(this);
								mRecycler =findViewById(R.id.lst_livre_recycl);
								rootLayout = (LinearLayout) findViewById(R.id.rootLayout);
								livre_Liste = db.getAllBooks();
								adapter = new RecyclerViewAdapter(livre_Liste,this);
								mLayoutManager = new LinearLayoutManager(this);
								mRecycler.setLayoutManager(mLayoutManager);
								mRecycler.setItemAnimator(new DefaultItemAnimator());
								mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
								mRecycler.setHasFixedSize(true);
								mRecycler.setAdapter(adapter);

								ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new SwipeToDeleteCallback(0,ItemTouchHelper.LEFT,this,getApplicationContext());
								new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecycler);
				}


				@Override
				public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
								if(viewHolder instanceof RecyclerViewAdapter.ViewHolder)
								{
											String titre = livre_Liste.get(viewHolder.getAdapterPosition()).get_titre();
												LivreHelper db = new LivreHelper(this);

												Livres deleteLivre = livre_Liste.get(viewHolder.getAdapterPosition());
												int deleteIndex = viewHolder.getAdapterPosition();
												db.deleteLivre(deleteLivre);
												adapter.removeItem(deleteIndex);

												Snackbar snackbar = Snackbar.make(mRecycler,titre +"Supprimer de la liste",Snackbar.LENGTH_LONG);
												snackbar.setAction("Annuler", new View.OnClickListener() {
																@Override
																public void onClick(View view) {
																				db.addAll(deleteLivre);
																				adapter.restoreItem(deleteLivre,deleteIndex);

																}
												});
												snackbar.setActionTextColor(Color.YELLOW);
												snackbar.show();
								}
				}
}