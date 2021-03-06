package com.uncc.appventures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.uncc.appventures.firebase.FirebaseService;
import com.uncc.appventures.model.CabinetMember;

import java.util.ArrayList;


public class CabinetActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private CabinetAdapter adapter;
    private ArrayList<CabinetMember> members = new ArrayList<CabinetMember>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), new RecyclerTouchListener.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CabinetMember member = members.get(position);

                Log.d("LGL", "clicked " + member.getName());

                LinearLayout info = (LinearLayout) view.findViewById(R.id.facts);

                info.setVisibility((info.getVisibility() == View.GONE ? View.VISIBLE : View.GONE));

                TextView experience = (TextView) info.findViewById(R.id.experience);
                experience.setText(member.getExperience());
                TextView joined = (TextView) info.findViewById(R.id.joined);
                joined.setText(member.getJoined());

                TextView major = (TextView) info.findViewById(R.id.major);
                major.setText(member.getMajor());
                TextView year = (TextView) info.findViewById(R.id.year);
                year.setText(member.getYear());
            }
        }));

        DatabaseReference myRef = FirebaseService.getRootRef();

        // Read from the database
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("LGL", "Called on data change");
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    CabinetMember mem = snapshot.getValue(CabinetMember.class);
                    members.add(mem);
                    Log.d("LGL", "Value is: " + mem.getName());
                }

                adapter = new CabinetAdapter(members);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("LGL", "Failed to read value.", error.toException());
            }
        });
    }
}