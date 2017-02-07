package com.uncc.appventures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CabinetActivity extends AppCompatActivity {
    private List<CabinetMember> cabinet = new ArrayList<>();
    private RecyclerView recyclerview;
    private CabinetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);

        recyclerview = (RecyclerView) findViewById(R.id.recycler);
        adapter = new CabinetAdapter(cabinet);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayout);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);

        //Gets data from firebase application
        retrieveInformation();
    }

    private void retrieveInformation() {
        //Gets Data from firebase

        adapter.notifyDataSetChanged();
    }

}
