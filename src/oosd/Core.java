package oosd;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hazwa
 */
class Core {

    private final ObservableList<Player> players = FXCollections.observableArrayList();
    private final ObservableList<Team> teams = FXCollections.observableArrayList();
    private final ObservableList<Matches> matches = FXCollections.observableArrayList();

    public void addPlayer(String playerName, int teamid) {
        Player player = new Player(playerName);
        players.add(player);
        teams.get(teamid).addPlayer(player);
    }

    public void addTeam(String teamName) {

        Team team = new Team(teamName);
        teams.add(team);
        team.setTeamid(teams.size());
    }

    public void generateFixtures() {
        matches.clear();
        teams.forEach((home) -> {
            teams.forEach((away) -> {
                if (!away.getName().equalsIgnoreCase(home.getName())) {
                    Matches matchHome = new Matches(home, away);
                    Matches matchAway = new Matches(away, home);
                    matchHome.setMatchid(matches.size());
                    matches.add(matchHome);
                    matchAway.setMatchid(matches.size());
                    matches.add(matchAway);

                }
            });
        });

    }

    public void generateRank() {
        int rank = 1;
        for (Team team : teams) {
            for (Team teamNext : teams) {
                if (team.getMatchesWon() > teamNext.getMatchesWon()) {
                    team.setRank(rank);
                } else if(team.getMatchesWon()==teamNext.getMatchesWon()) {
                    team.setRank(rank);
                }
                else{
                    team.setRank(rank+1);
                }
            }
        }

    }

    public ObservableList<Player> getPlayers() {
        return players;
    }

    public ObservableList<Team> getTeams() {
        return teams;
    }

    public ObservableList<Matches> getMatches() {
        return matches;
    }

}
