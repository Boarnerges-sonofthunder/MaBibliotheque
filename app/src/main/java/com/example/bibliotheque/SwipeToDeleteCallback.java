package com.example.bibliotheque;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
				private MyAdapter mAdapter;
				private Drawable icon;
				//private final ColorDrawable background;
				private List<Livres> myLivre = new ArrayList<>();
				//private RecyclerView mRecycler;
				private RecyclerItemTouchHelperListener listener;

				public SwipeToDeleteCallback(int dragDirs, int swipeDirs,RecyclerItemTouchHelperListener listener) {
								super(dragDirs, swipeDirs);
								this.listener = listener;
				}



				/*public SwipeToDeleteCallback(RecyclerViewAdapter adapter) {
								super(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
								this.mAdapter = adapter;
								this.icon = ContextCompat.getDrawable(adapter.getContext(),R.drawable.ic_delete);

								this.background = new ColorDrawable(Color.RED);
				}*/

				@Override
				public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
								/*super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
								View itemView = viewHolder.itemView;*/
								//TODO:Essayer de faire apparaitre une image de corbeil quand je supprime un livre
								View foregroundView = ((RecyclerViewAdapter.ViewHolder)viewHolder).itemView;
								getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

								/*int backgroundCornerOffset = 20;

								int iconMargin = (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
								int iconTop = itemView.getTop() + (itemView.getHeight() - icon.getIntrinsicHeight()) / 2;
								int iconBottom = iconTop + icon.getIntrinsicHeight();

								if(dX > 0) //swipe a droite
								{
												int iconLeft = itemView.getLeft() + iconMargin + icon.getIntrinsicWidth();
												int iconRight = itemView.getLeft() + iconMargin;
												icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
												background.setBounds(itemView.getLeft(),itemView.getTop(),itemView.getLeft() + ((int) dX) + backgroundCornerOffset,itemView.getBottom());
								}
								else if (dX < 0) //swipe a gauche
								{
												int iconLeft = itemView.getRight() - iconMargin - icon.getIntrinsicWidth();
												int iconRight = itemView.getRight() - iconMargin;
												icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
												background.setBounds(itemView.getRight() + ((int) dX) - backgroundCornerOffset,itemView.getTop(),itemView.getRight(),itemView.getBottom());
								}
								else //le view n'est pas deplacé
								{
												background.setBounds(0,0,0,0);
								}
								background.draw(c);
								icon.draw(c);*/
				}

				@Override
				public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
								View foregroundView = ((RecyclerViewAdapter.ViewHolder)viewHolder).itemView;
								getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
				}

				@Override
				public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
								return true;
				}

				@Override
				public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
								/*int position = viewHolder.getAdapterPosition();
								myLivre.remove(position);
								mRecycler.getAdapter().notifyItemRemoved(position);*/

								if(listener != null)
								{
												listener.onSwiped(viewHolder,direction,viewHolder.getAdapterPosition());
								}

				}

				@Override
				public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
								View foregroundView = ((RecyclerViewAdapter.ViewHolder)viewHolder).itemView;
								getDefaultUIUtil().clearView(foregroundView);
				}

				@Override
				public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
								if(viewHolder != null)
								{
												View foregroundView = ((RecyclerViewAdapter.ViewHolder)viewHolder).itemView;
												getDefaultUIUtil().onSelected(foregroundView);
								}
				}

				@Override
				public int convertToAbsoluteDirection(int flags, int layoutDirection) {
								return super.convertToAbsoluteDirection(flags, layoutDirection);
				}
}
