package com.example.vkfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vkfragment.models.DataNews;
import com.example.vkfragment.models.News;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    //container for all news from database
    public List<News> items = new ArrayList<>();

    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private NewsAdapter.ItemClickListener listener = null;
    private final String STATE = "recycler_state";
    private static Bundle recyclerviewState;

    public HomeFragment(){
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listener = new NewsAdapter.ItemClickListener() {
            @Override
            public void itemClick(int position, News item) {
                Intent intent = new Intent(getActivity(),NewsDetailActivity.class);
                intent.putExtra("news", item);
                startActivity(intent);
            }
        };

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new NewsAdapter(generateNews(), listener);
        recyclerView.setAdapter(adapter);

    }
    //return data from newsDATABASE
    private List<News> generateNews() {
        items = DataNews.news;
        return items;
    }

    @Override
    public void onResume(){
        super.onResume();
        if (recyclerviewState != null){
            Parcelable listState = recyclerviewState.getParcelable(STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        recyclerviewState = new Bundle();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        recyclerviewState.putParcelable(STATE, listState);
    }
}
