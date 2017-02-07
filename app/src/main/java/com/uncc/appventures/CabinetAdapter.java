package com.uncc.appventures;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CabinetAdapter extends RecyclerView.Adapter<CabinetAdapter.MyViewHolder> {

    private List<CabinetMember> memberList;

    public CabinetAdapter(List<CabinetMember> memberList) {
        this.memberList = memberList;
    }

    @Override
    public CabinetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View memberView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cabinet_list, parent, false);
        return new MyViewHolder(memberView);
    }

    @Override
    public void onBindViewHolder(CabinetAdapter.MyViewHolder holder, int place) {
        CabinetMember member = memberList.get(place);
        holder.name.setText(member.getName());
        holder.position.setText(member.getPosition());
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, position;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            position = (TextView) view.findViewById(R.id.position);
        }
    }
}
