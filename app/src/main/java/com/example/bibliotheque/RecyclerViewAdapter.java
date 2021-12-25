package com.example.bibliotheque;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
				List<Livres> lst_livre;
				Context context;
				int id;
				//Livres livre = null;
				//EditText titre;
				//EditText ed;

				public RecyclerViewAdapter(List<Livres> lst_livre, Context context) {
								this.lst_livre = lst_livre;
								this.context = context;
								//this.ed = new EditText(context);
				}

				@NonNull
				@Override
				public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
								View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_livre,parent,false);
								//on prend le layout et on l'associe a notre viewHolder
								ViewHolder holder = new ViewHolder(view);
								return holder;
				}

				@Override
				public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
								final Livres livre = lst_livre.get(position);
								// On attribut une valeur a nos element du layout
							holder.lblTitre.setText(lst_livre.get(position).get_titre());
							holder.lblLocal.setText(lst_livre.get(position).get_localisation());
							//Permet d'attribuer une image *NE PAS OUBLIER DE METTRE LA PERMISSION D'ACCES A INTERNET DANS LE MANIFESTE et l'implementation dans build.gradle
							Glide.with(this.context).load(lst_livre.get(position).get_imgUrl()).into(holder.txtUrlimage);

							//LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
							//ed.setLayoutParams(lp);
							//TODO:Trouver comment afficher un alertDialog
								holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener(){
												@Override
												public boolean onLongClick(View v) {
																editLivre(livre);

																return true;
												}
								});

								//int newPosition = holder.getAdapterPosition();


				}

				@Override
				public int getItemCount() {
								//defini le nombre d'element qui vont apparaitre dans le recyclerview, on utilise le size de notre liste
								return lst_livre.size();
				}

				//ViewHolder est une reference a mon layout_livre
				public static class ViewHolder extends RecyclerView.ViewHolder{
								//on defini les elements dans le layout_livre.xml
								TextView lblTitre;
								TextView lblLocal;
								ImageView txtUrlimage;
								LinearLayout parentLayout;
								EditText titre;
								EditText auteur;
								EditText editeur;
								EditText nbPage;
								EditText prix;
								EditText anneePub;
								EditText local;
								EditText imUrl;

								public ViewHolder(@NonNull View itemView) {
												super(itemView);
												lblTitre = itemView.findViewById(R.id.lblTitre);
												lblLocal = itemView.findViewById(R.id.lblLocal);
												txtUrlimage = itemView.findViewById(R.id.imgLivre);
												parentLayout = itemView.findViewById(R.id.oneLineBookLayout);
												titre = itemView.findViewById(R.id.txtTitreMod);
												auteur = itemView.findViewById(R.id.txtAuteurMod);
												editeur = itemView.findViewById(R.id.txtEditeurMod);
												nbPage = itemView.findViewById(R.id.txtNbPageMod);
												prix = itemView.findViewById(R.id.txtPrixmod);
												anneePub = itemView.findViewById(R.id.txtAnneePubMod);
												local = itemView.findViewById(R.id.txtLocalMod);
												imUrl = itemView.findViewById(R.id.txtUrlImageMod);

								}
				}

				public void removeItem(int position)
				{
								lst_livre.remove(position);
								notifyItemRemoved(position);
								notifyItemRangeChanged(position, lst_livre.size());
				}

				public void restoreItem(Livres livre,int position)
				{
								lst_livre.add(position,livre);
								notifyItemInserted(position);
				}

				public void editLivre(Livres livre)
				{
								//On affiche la page pour faire un update du livre
																LayoutInflater inflater = LayoutInflater.from(context);
																View subView = inflater.inflate(R.layout.custom_edit_dialog,null);

																final TextView id = subView.findViewById(R.id.lblLivreId);
																final EditText titre = subView.findViewById(R.id.txtTitreMod);
																final EditText auteur = subView.findViewById(R.id.txtAuteurMod);
																final EditText editeur = subView.findViewById(R.id.txtEditeurMod);
																final EditText nbPage = subView.findViewById(R.id.txtNbPageMod);
																final EditText prix = subView.findViewById(R.id.txtPrixmod);
																final EditText anneePub = subView.findViewById(R.id.txtAnneePubMod);
																final EditText local = subView.findViewById(R.id.txtLocalMod);
																final EditText imUrl = subView.findViewById(R.id.txtUrlImageMod);

																if(livre != null){
																				id.setText(String.valueOf(livre.get_id()));
																				titre.setText(livre.get_titre());
																				auteur.setText(livre.get_auteur());
																				editeur.setText(livre.get_editeur());
																				nbPage.setText(String.valueOf(livre.get_nbPage()));
																				prix.setText(String.valueOf(livre.get_prix()));
																				anneePub.setText(livre.get_anneePub());
																				local.setText(livre.get_localisation());
																				imUrl.setText(livre.get_imgUrl());
																}

																AlertDialog.Builder myDialog = new AlertDialog.Builder(context);
																myDialog.setTitle("Modifier ce livre");
																myDialog.setView(subView);
																myDialog.create();

																//Approuver la modification
																myDialog.setPositiveButton("Appliquer", new DialogInterface.OnClickListener() {
																				@Override
																				public void onClick(DialogInterface dialogInterface, int i) {
																								final String tit = titre.getText().toString();
																								final String aut = auteur.getText().toString();
																								final String edit = editeur.getText().toString();
																								final int nPage = Integer.parseInt(nbPage.getText().toString());
																								final double pri = Double.parseDouble(prix.getText().toString());
																								final String annee = anneePub.getText().toString();
																								final String loca = local.getText().toString();
																								final String iUrl = imUrl.getText().toString();

																								//faire le update
																								LivreHelper db = new LivreHelper(context);
																								assert livre != null;
																								Livres livreUpdate = new Livres(livre.get_id(),tit, aut, edit, nPage, pri, annee, loca, iUrl);
																								((AfficherLivreRecyleView)context).finish();
																								context.startActivity(((AfficherLivreRecyleView)context).getIntent());

																								db.updateLivre(livreUpdate);
																				}
																});

																//Annuler la modification
																myDialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
																				@Override
																				public void onClick(DialogInterface dialogInterface, int i) {
																								dialogInterface.cancel();
																				}
																});
																myDialog.show();
				}
}
