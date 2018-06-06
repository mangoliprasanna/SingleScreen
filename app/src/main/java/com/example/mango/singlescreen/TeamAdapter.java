package com.example.mango.singlescreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamMemberViewHolder> {

    private List<TeamMember> teamList;
    @Override
    public TeamMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_team, parent, false);

        return new TeamMemberViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeamMemberViewHolder holder, int position) {

        TeamMember teamMember = teamList.get(position);
        holder.teamName.setText(teamMember.getTeamName());
        holder.teamPosition.setText(teamMember.getTeamPosition());
        Picasso.get()
                .load(teamMember.getTeamProfileLink())
                .into(holder.teamProfile);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class TeamMemberViewHolder extends RecyclerView.ViewHolder{
        public TextView teamPosition, teamName;
        public ImageView teamProfile;

        public TeamMemberViewHolder(View view) {
            super(view);
            teamName = (TextView) view.findViewById(R.id.teamName);
            teamPosition = (TextView) view.findViewById(R.id.teamPosition);
            teamProfile = (ImageView) view.findViewById(R.id.profile_image);

        }
    }

    public TeamAdapter(List<TeamMember> teamMemberList) {
        this.teamList = teamMemberList;
    }


}
