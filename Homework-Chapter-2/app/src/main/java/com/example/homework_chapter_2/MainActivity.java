package com.example.homework_chapter_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();

    private SearchLayout mSearchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchAdapter);

        final List<String> items = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            items.add("这是第 " + i + " 行");
        }
        mSearchAdapter.notifyItems(items);

        mSearchLayout = findViewById(R.id.search);
        mSearchLayout.setOnSearchTextChangedListener(new SearchLayout.OnSearchTextChangedListener() {
            @Override
            public void afterChanged(String text) {
                Log.i(TAG, "afterChanged: " + text);
                List<String> filters = new ArrayList<>();
                for (String item : items) {
                    if (item.contains(text)) {
                        filters.add(item);
                    }
                }
                mSearchAdapter.notifyItems(filters);
            }
        });

    }
}