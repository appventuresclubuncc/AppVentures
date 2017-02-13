package com.uncc.appventures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), new RecyclerTouchListener.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CabinetMember member = members.get(position);
                LinearLayout info = (LinearLayout) findViewById(R.id.facts);
                info.setVisibility(View.VISIBLE);
                TextView name = (TextView) findViewById(R.id.memName);
                name.setText(member.getName());
                TextView pos = (TextView) findViewById(R.id.pos);
                pos.setText(member.getPosition());
                TextView major = (TextView) findViewById(R.id.major);
                major.setText(member.getMajor());
                TextView concentration = (TextView) findViewById(R.id.concentration);
                concentration.setText(member.getConcentration());
                TextView reason = (TextView) findViewById(R.id.reason);
                reason.setText(member.getReason());
                TextView grad = (TextView) findViewById(R.id.grad);
                grad.setText(member.getGradDate());
            }
        }));

        members.add(new CabinetMember("Mikey", "President", R.drawable.family_younger_brother, "Computer Science", "Cyber Security", "Fun", "May 2018"));
        members.add(new CabinetMember("Tony", "Vice-president", R.drawable.family_son, "Africana Studies", "Africa", "Boredom", "Graduated already"));
        members.add(new CabinetMember("Rose", "Secretary", R.drawable.family_mother, "Nursing", "Oncology", "Getting back to school", "Graduated already"));
        members.add(new CabinetMember("Asia", "Liaison", R.drawable.family_older_sister, "Pre-nursing", "General education", "Going to school", "Haven't started"));
        members.add(new CabinetMember("Michael", "Treasurer", R.drawable.family_father, "Engineering", "Telecommunications", "Learning new technology", "Not going to school"));
        adapter = new CabinetAdapter(members);
        mRecyclerView.setAdapter(adapter);
    }
}