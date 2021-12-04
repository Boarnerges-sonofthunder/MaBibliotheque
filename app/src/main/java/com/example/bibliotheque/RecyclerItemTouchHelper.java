package com.example.bibliotheque;

import androidx.recyclerview.widget.RecyclerView;

interface RecyclerItemTouchHelperListener {
				void onSwiped(RecyclerView.ViewHolder viewHolder, int direction,int position);
}
