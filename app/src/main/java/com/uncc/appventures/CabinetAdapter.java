package com.uncc.appventures;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CabinetAdapter extends RecyclerView.Adapter<CabinetAdapter.MyHolder> {
    private ArrayList<CabinetMember> memberList;

    public static class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImage;
        private TextView mName;
        private TextView mPosition;

        public MyHolder(View v) {
            super(v);
            mImage = (ImageView) v.findViewById(R.id.image);
            mName = (TextView) v.findViewById(R.id.name);
            mPosition = (TextView) v.findViewById(R.id.position);
        }

        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            Intent showMemberIntent = new Intent(context, CabinetActivity.class);
            context.startActivity(showMemberIntent);
        }
    }

    public CabinetAdapter(ArrayList<CabinetMember> memberList) {
        this.memberList = memberList;
    }

    @Override
    public CabinetAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member, parent, false);
        return new MyHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(CabinetAdapter.MyHolder holder, int position) {
        CabinetMember member = memberList.get(position);
        holder.mName.setText(member.getName());
        holder.mPosition.setText(member.getPosition());
        holder.mImage.setImageResource(member.getImageId());
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }
}
