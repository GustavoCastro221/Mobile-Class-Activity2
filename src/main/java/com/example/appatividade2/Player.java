package com.example.appatividade2;

public class Player {
    String name;
    String team;

    @Override
    public String toString() {
        return "Player  : " + name + "  Team  : " + team + "/";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
