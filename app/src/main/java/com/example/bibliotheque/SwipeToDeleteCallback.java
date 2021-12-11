package com.example.bibliotheque;

import android.content.Context;
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
				private final ColorDrawable background;
				private List<Livres> myLivre = new ArrayList<>();
				//private RecyclerView mRecycler;
				private RecyclerItemTouchHelperListener listener;

				public SwipeToDeleteCallback(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener, Context context) {
								super(dragDirs, swipeDirs);
								this.listener = listener;
								this.icon = ContextCompat.getDrawable(context,R.drawable.ic_delete);
								this.background = new ColorDrawable(Color.RED);
				}

				@Override
				public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
								View foregroundView = ((RecyclerViewAdapter.ViewHolder)viewHolder).itemView;
								getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

								int backgroundCornerOffset = 20;

								int iconMargin = (foregroundView.getHeight() - icon.getIntrinsicHeight()) / 2;
								int iconTop = foregroundView.getTop() + (foregroundView.getHeight() - icon.getIntrinsicHeight()) / 2;
								int iconBottom = iconTop + icon.getIntrinsicHeight();

								if(dX > 0) //swipe a droite
								{
												int iconLeft = foregroundView.getLeft() + iconMargin + icon.getIntrinsicWidth();
												int iconRight = foregroundView.getLeft() + iconMargin;
												icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
												background.setBounds(foregroundView.getLeft(),foregroundView.getTop(),foregroundView.getLeft() + ((int) dX) + backgroundCornerOffset,foregroundView.getBottom());
								}
								else if (dX < 0) //swipe a gauche
								{
												int iconLeft = foregroundView.getRight() - iconMargin - icon.getIntrinsicWidth();
												int iconRight = foregroundView.getRight() - iconMargin;
												icon.setBounds(iconLeft, iconTop, iconRight, iconBottom);
												background.setBounds(foregroundView.getRight() + ((int) dX) - backgroundCornerOffset,foregroundView.getTop(),foregroundView.getRight(),foregroundView.getBottom());
								}
								else //le view n'est pas deplacé
								{
												background.setBounds(0,0,0,0);
												icon.setBounds(0,0,0,0);
								}
								background.draw(c);
								icon.draw(c);
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
