package oosd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hazwa
 */
public class Team {

    private String name;
    private final ObservableList<Player> players = FXCollections.observableArrayList();
    private int teamid;
    private int matchesPlayed;
    private int matchesWon;
    private int setsWon;
    private int rank;

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);

    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public void setSetsWon(int setsWon) {
        this.setsWon = setsWon;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ObservableList<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
