package com.example.bibliotheque;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
				List<Livres> lst_livre;
				Context context;

				public RecyclerViewAdapter(List<Livres> lst_livre, Context context) {
								this.lst_livre = lst_livre;
								this.context = context;
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
				public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
								//On attribut une valeur a nos element du layout
							holder.lblTitre.setText(lst_livre.get(position).get_titre());
							holder.lblLocal.setText(lst_livre.get(position).get_localisation());
							//Permet d'attribuer une image *NE PAS OUBLIER DE METTRE LA PERMISSION D'ACCES A INTERNET DANS LE MANIFESTE et l'implementation dans build.gradle
							Glide.with(this.context).load(lst_livre.get(position).get_imgUrl()).into(holder.txtUrlimage);

							//TODO:Trouver comment afficher un alertDialog
							//On affiche la page pour faire un update du livre
							holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
											@Override
											public boolean onLongClick(View view) {
															AlertDialog.Builder myDialog = new AlertDialog.Builder(context);
															myDialog.setTitle("Modifier ce livre");
															myDialog.setView(R.layout.custom_edit_dialog);

															//Approuver la modification
															myDialog.setPositiveButton("Appliquer", new DialogInterface.OnClickListener() {
																			@Override
																			public void onClick(DialogInterface dialogInterface, int i) {
																							//faire le update
																							Toast.makeText(context,"alert dialog",Toast.LENGTH_LONG).show();
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

								public ViewHolder(@NonNull View itemView) {
												super(itemView);
												lblTitre = itemView.findViewById(R.id.lblTitre);
												lblLocal = itemView.findViewById(R.id.lblLocal);
												txtUrlimage = itemView.findViewById(R.id.imgLivre);
												parentLayout = itemView.findViewById(R.id.oneLineBookLayout);
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
}
