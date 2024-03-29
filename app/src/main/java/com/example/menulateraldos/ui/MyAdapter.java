package com.example.menulateraldos.ui;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menulateraldos.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private int[] images;

    public MyAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.imageNumberTextView.setText("Card " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        ImageView imageView;
        TextView imageNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            imageNumberTextView = itemView.findViewById(R.id.imageNumberTextView);

            itemView.setOnCreateContextMenuListener(this); // Registrar para el menú contextual
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(), R.id.action_edit, 0, "Editar");
            menu.add(this.getAdapterPosition(), R.id.action_delete, 1, "Eliminar");
            menu.add(this.getAdapterPosition(), R.id.action_share, 2, "Compartir");
        }
    }


}
