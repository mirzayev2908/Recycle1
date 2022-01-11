package com.example.recycle1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recycle1.R;
import com.example.recycle1.adapter.CustomAdapter;
import com.example.recycle1.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        List<com.example.recycle1.model.Member> members = prepareMemerList();
        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);

    }

    private List<com.example.recycle1.model.Member> prepareMemerList() {
        List<com.example.recycle1.model.Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new com.example.recycle1.model.Member("Mirzayev " + i, "Shaxzod " + i));
        }
        return members;
    }

}