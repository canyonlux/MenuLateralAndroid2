package com.example.menulateraldos.ui.gallery;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menulateraldos.R;
import com.example.menulateraldos.ui.MyAdapter;

public class GalleryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2)); // 2 columnas

        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3,R.drawable.image4, R.drawable.image5, R.drawable.image6,R.drawable.image7, R.drawable.image8, R.drawable.image9}; // Tus imágenes
        MyAdapter adapter = new MyAdapter(images);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = item.getGroupId(); // Obtiene la posición desde el ID del grupo

        int id = item.getItemId();
        if (id == R.id.action_edit) {
            // Manejar edición para la posición
            return true;
        } else if (id == R.id.action_delete) {
            // Manejar eliminación para la posición
            return true;
        } else if (id == R.id.action_share) {
            // Manejar compartición para la posición
            return true;
        }

        return super.onContextItemSelected(item);
    }

}



