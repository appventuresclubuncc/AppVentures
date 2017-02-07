package com.uncc.appventures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

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

        // Touch Listener
        recyclerview.addOnItemTouchListener(new RecycleTouchListen(getApplicationContext(), recyclerview, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                CabinetMember member = cabinet.get(position);
                Toast.makeText(getApplicationContext(), member.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));

        //Gets data from firebase application
        retrieveInformation();
    }

    private void retrieveInformation() {
        //Gets Data from firebase

        // Test data
        CabinetMember president = new CabinetMember("Chris", "President");
        cabinet.add(president);
        adapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onLongClick(View child, int childLayoutPosition);

        void onClick(View child, int childLayoutPosition);
    }
}
