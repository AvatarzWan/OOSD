/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author hazwa
 */
class Score extends GridPane {

    private final Core app;
    private Matches match;
    private final VBox scoreSheetBox = scoreSheetBox();

    Score(Core handler) {
        
        this.app = handler;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().addAll(scoreSheetBox,scoreGrid());
        
    }

    private VBox scoreSheetBox() {
        
        VBox root = new VBox();

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);

        GridPane gridPaneBtn = new GridPane();
        gridPaneBtn.setAlignment(Pos.CENTER);
        
        ComboBox<Team>homeBox = new ComboBox();
        homeBox.setItems(app.getTeams());
        homeBox.setPromptText("Select home team:");
        Team homeTeam = homeBox.getValue();
        
        ComboBox<Team> awayBox = new ComboBox();
        awayBox.setItems(app.getTeams());
        awayBox.setPromptText("Select away team:");
        Team awayTeam = awayBox.getValue();
        
        
        ScoreTeamMatch(homeTeam,awayTeam);
        

        ComboBox<Player> player1 = new ComboBox();
        player1.setItems(homeTeam.getPlayers());
        player1.setPromptText("Select home player:");

        ComboBox<Player> player2 = new ComboBox();
        player2.setItems(homeTeam.getPlayers());
        player2.setPromptText("Select home player:");

        ComboBox<Player> player3 = new ComboBox();
        player3.setItems(awayTeam.getPlayers());
        player3.setPromptText("Select away player:");

        ComboBox<Player> player4 = new ComboBox();
        player4.setItems(awayTeam.getPlayers());
        player4.setPromptText("Select away player:");

        Button newSheet = new Button("New");
        Button modifySheet = new Button("Modify");
        Button calcScores = new Button("Calculate and Submit");

        Label singleSets = new Label("Single Sets");
        Label doubleSets = new Label("Double Sets");
         GridPane gridPane = new GridPane();

        
        gridPane.add(singleSets, 0, 0);
        gridPane.add(doubleSets, 0, 4);
        gridPane.add(player1, 1, 0);
        gridPane.add(player2, 2, 0);
        gridPane.add(player3, 0, 1);
        gridPane.add(player4, 0, 2);
        

        gridPaneBtn.add(newSheet, 0, 0);
        gridPaneBtn.add(modifySheet, 1, 0);
        gridPaneBtn.add(homeBox, 1, 1);
        gridPaneBtn.add(awayBox, 0, 1);

        //calcScores.setOnAction(e -> {
        //});
        //newSheet.setOnAction(e -> {
        // });
        //modifySheet.setOnAction(e -> {
        //});
        vbox.getChildren().add(gridPane);
        vbox1.getChildren().add(calcScores);

        root.getChildren().addAll(vbox, vbox1);

        return root;

    }
    
    private GridPane scoreGrid(){
        
        GridPane gridPaneScore = new GridPane();
        gridPaneScore.setAlignment(Pos.CENTER);
        gridPaneScore.setPadding(new Insets(5));
        gridPaneScore.setHgap(2);
        gridPaneScore.setVgap(2);
        
        GridPane gridPaneSet1 = new GridPane();
        gridPaneSet1.setAlignment(Pos.CENTER);

        GridPane gridPaneSet2 = new GridPane();
        gridPaneSet2.setAlignment(Pos.CENTER);

        GridPane gridPaneSet3 = new GridPane();
        gridPaneSet3.setAlignment(Pos.CENTER);

        GridPane gridPaneSet4 = new GridPane();
        gridPaneSet4.setAlignment(Pos.CENTER);

        GridPane gridPaneSet5 = new GridPane();
        gridPaneSet5.setAlignment(Pos.CENTER);
        
        TextField addScore1 = new TextField();
        TextField addScore2 = new TextField();
        TextField addScore3 = new TextField();
        TextField addScore4 = new TextField();
        TextField addScore5 = new TextField();
        TextField addScore6 = new TextField();
        TextField addScore7 = new TextField();
        TextField addScore8 = new TextField();
        TextField addScore9 = new TextField();
        TextField addScore10 = new TextField();
        TextField addScore11 = new TextField();
        TextField addScore12 = new TextField();
        TextField addScore13 = new TextField();
        TextField addScore14 = new TextField();
        TextField addScore15 = new TextField();

        gridPaneSet1.add(addScore1, 0, 0);
        gridPaneSet1.add(addScore2, 0, 1);
        gridPaneSet1.add(addScore3, 0, 2);

        gridPaneSet2.add(addScore4, 0, 0);
        gridPaneSet2.add(addScore5, 0, 1);
        gridPaneSet2.add(addScore6, 0, 2);

        gridPaneSet3.add(addScore7, 0, 0);
        gridPaneSet3.add(addScore8, 0, 1);
        gridPaneSet3.add(addScore9, 0, 2);

        gridPaneSet4.add(addScore10, 0, 0);
        gridPaneSet4.add(addScore11, 0, 1);
        gridPaneSet4.add(addScore12, 0, 2);

        gridPaneSet5.add(addScore13, 0, 0);
        gridPaneSet5.add(addScore14, 0, 1);
        gridPaneSet5.add(addScore15, 0, 2);
        
        gridPaneScore.add(gridPaneSet2, 1, 1);
        gridPaneScore.add(gridPaneSet2, 2, 1);
        gridPaneScore.add(gridPaneSet3, 1, 2);
        gridPaneScore.add(gridPaneSet4, 2, 2);
        gridPaneScore.add(gridPaneSet5, 1, 3);
        
        return gridPaneScore;

    }
    
    private void ScoreTeamMatch(Team homeTeam, Team awayTeam) {


        //Matches match;
        if (app.getMatches()
                .size() <= 1) {
            app.generateFixtures();
        }
         int matchID = -1;
        for (Matches match : app.getMatches()) {
            if (match.getHome().getTeamid() == homeTeam.getTeamid()) {
                if (match.getAway().getTeamid() == awayTeam.getTeamid()) {
                    matchID = match.getMatchid();
                    this.match = app.getMatches().get(matchID);
                    break;
                }
            }
        }



}
}
