package oosd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hazwa
 */
public class Matches {

    private int matchid;
    private Team home;
    private Team away;

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    
    private int[][][] scores;

    private String status;

    Matches(Team home, Team away) {
        this.home = home;
        this.away = away;
        this.status = "Not Played";
        scores = new int[5][3][2];
        
        for (int[][] i : scores) {
            for (int[] j : i) {
                for (int k : j) {
                    k = -1;
                }
            }
    }
    }

    public int getMatchid() {
        return matchid;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer4() {
        return player4;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public void setPlayer4(Player player4) {
        this.player4 = player4;
    }


    public int[][][] getScores() {
        return scores;
    }

    public void setScores(int[][][] scores) {
        this.scores = scores;
        
    }

    public void setScores(int set, int game, int[] points) {
        if (set >= 0 && set <= 5) {
            if (game >= 0 && game <= 3) {
                if (points[0] >= 0 && points[1] >= 0) {
                    scores[set][game] = points;
                }
            }
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ("Match:  id=" + matchid + ", homeTeam=" + home + ", awayTeam=" + away + ", score :" + scores);
    }

}
