package com.example.mango.singlescreen;

public class TeamMember {
    private String teamProfileLink, teamName, teamPosition;

    public TeamMember(String _profileLink, String _teamName, String _teamPosition)
    {
        this.teamProfileLink = _profileLink;
        this.teamName = _teamName;
        this.teamPosition = _teamPosition;
    }

    public String getTeamName(){ return teamName; }
    public String getTeamProfileLink() { return teamProfileLink; }
    public String getTeamPosition() { return  teamPosition;  }


}
