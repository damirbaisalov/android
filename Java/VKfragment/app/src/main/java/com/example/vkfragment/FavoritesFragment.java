package com.example.vkfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vkfragment.models.News;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    public static List<News> favoriteNews = new ArrayList<>(); // container for favorite news

    private RecyclerView favRecyclerView;
    private LikedNewsAdapter newAdapter;
    private LikedNewsAdapter.ItemClickListener listener = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        favRecyclerView = view.findViewById(R.id.fav_recyclerView);
        favRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        listener = new LikedNewsAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("news", item);
                startActivity(intent);
            }
        };

        newAdapter = new LikedNewsAdapter(generateNews(), listener);
        favRecyclerView.setAdapter(newAdapter);

    }

    private List<News> generateNews(){
        return favoriteNews;
    }
}
