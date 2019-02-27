package oosd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hazwa
 *
 */
class Admin extends VBox {

    private final Core app;

    public Admin(Core handler) {

        this.app = handler;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().addAll(newAddPane(), generatePane());
        this.setSpacing(6);
    }

    private GridPane newAddPane() {

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 250);
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(7);
        gridPane.setHgap(7);

        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER);

        ComboBox<Team> teamselect = new ComboBox();
        teamselect.setItems(app.getTeams());
        teamselect.setPromptText("Select the team");

        Button addTeam = new Button("Add team");
        Button addPlayer = new Button("Add player");
        TextField addPlayerTxt = new TextField();
        TextField addTeamTxt = new TextField();

        gridPane.add(new Label("ADMIN"), 0, 0);
        gridPane.add(addTeam, 0, 1);
        gridPane.add(addTeamTxt, 1, 1);
        gridPane.add(addPlayer, 0, 2);
        gridPane.add(addPlayerTxt, 1, 2);
        gridPane.add(teamselect, 1, 3);

        addTeam.setMaxWidth(Double.MAX_VALUE);
        addPlayer.setMaxWidth(Double.MAX_VALUE);

        addTeam.setOnAction(e -> {
            app.addTeam(addTeamTxt.getText());
            addTeamTxt.clear();
        });

        addPlayer.setOnAction(e -> {
            app.addPlayer(addPlayerTxt.getText(), teamselect.getValue().getTeamid());
        });
        return gridPane;

    }

    private GridPane generatePane() {
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 250);
        //Setting the padding  
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(7);
        gridPane.setHgap(7);

        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER);
        Button genFixtures = new Button("Fixtures");
        Button genTeamStats = new Button("Team Stats");
        gridPane.add(new Label("Generate"), 0, 0);
        gridPane.add(genFixtures, 0, 2);
        gridPane.add(genTeamStats, 1, 2);
        Button genTest = new Button("Test");
        gridPane.add(genTest, 1, 3);

        genFixtures.setOnAction(e -> {
            app.generateFixtures();
        });

        genTeamStats.setOnAction(e -> {         

        });

        genTest.setOnAction(e -> {
            generateTestData();
        });

        return gridPane;
    }

    private void generateTestData() {
        app.addTeam("Team A");
        app.addTeam("Team B");
        app.addTeam("Team C");
        app.addTeam("Team D");
        app.addTeam("Team E");
        app.addTeam("Team F");
        app.addTeam("Team G");

        app.addPlayer("Hazwan", 0);
        app.addPlayer("Izzani", 1);
        app.addPlayer("Rico", 2);
        app.addPlayer("Ball", 3);
        app.addPlayer("Mohammed", 4);
        app.addPlayer("Younus", 5);
        app.addPlayer("Zack", 6);

        app.addPlayer("Efron", 0);
        app.addPlayer("Harry", 1);
        app.addPlayer("Potter", 2);
        app.addPlayer("Albus", 3);
        app.addPlayer("Dumbledore", 4);
        app.addPlayer("Severus", 5);
        app.addPlayer("Snape", 6);
    }
}
