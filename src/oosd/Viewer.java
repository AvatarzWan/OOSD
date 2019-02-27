package oosd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;

/**
 *
 * @author hazwa
 *
 */
class Viewer extends VBox {

    private final Core app;
    private final VBox viewerGroup = viewerGroup();

    public Viewer(Core handler) {

        this.app = handler;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.getChildren().addAll(viewerGroup, fixtures());
        this.setSpacing(6);
    }

    public VBox viewerGroup() {

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(250, 250);
        //Setting the padding  
        gridPane.setPadding(new Insets(2, 2, 2, 2));
        //gridPane.setPrefWidth(20);

        //Setting the vertical and horizontal gaps between the columns 
        gridPane.setVgap(2);
        gridPane.setHgap(2);

        //Setting the Grid alignment 
        gridPane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Button viewFixtures = new Button("Fixtures");
        Button viewTeamstats = new Button("Team stats");
        Button viewTeamranking = new Button("Team Ranking");
        Button viewMatchscores = new Button("Match Scores");
        vbox.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Viewer"), 0, 0);
        gridPane.add(viewFixtures, 0, 2);
        gridPane.add(viewTeamstats, 0, 3);
        gridPane.add(viewTeamranking, 0, 4);
        gridPane.add(viewMatchscores, 0, 5);

        viewFixtures.setMaxWidth(Double.MAX_VALUE);
        viewTeamstats.setMaxWidth(Double.MAX_VALUE);
        viewTeamranking.setMaxWidth(Double.MAX_VALUE);
        viewMatchscores.setMaxWidth(Double.MAX_VALUE);

        vbox.getChildren().add(gridPane);

        viewFixtures.setOnAction(e -> {
            this.getChildren().retainAll(vbox);
            this.getChildren().add(fixtures());
        });

        viewTeamstats.setOnAction(e -> {
            this.getChildren().retainAll(vbox);
            this.getChildren().add(stats());
        });

        viewTeamranking.setOnAction(e -> {
            app.generateRank();
            this.getChildren().retainAll(vbox);
            this.getChildren().add(ranks());

        });

        viewMatchscores.setOnAction(e -> {
            this.getChildren().retainAll(vbox);
            this.getChildren().add(matchScores());

        });

        return vbox;
    }

    private VBox fixtures() {
        VBox fixtures = new VBox();

        ComboBox<Team> selectTeam = new ComboBox<>(app.getTeams());
        selectTeam.setPromptText("Select team:");

        TableView fixturesTable = new TableView();

        TableColumn<Matches, String> home = new TableColumn<>("Home Team");
        home.setCellValueFactory(new PropertyValueFactory<Matches, String>("home"));
        TableColumn<Matches, String> away = new TableColumn<>("Away Team");
        away.setCellValueFactory(new PropertyValueFactory<Matches, String>("away"));
        TableColumn<Matches, String> results = new TableColumn<>("Results");
        results.setCellValueFactory(new PropertyValueFactory<Matches, String>("status"));

        fixturesTable.setItems(app.getMatches());
        fixturesTable.getColumns().addAll(home, away, results);
        fixtures.getChildren().addAll(selectTeam, fixturesTable);

        return fixtures;
    }

    private VBox stats() {
        VBox stats = new VBox();
        stats.setSpacing(5);

        TableView<Team> tableStats = new TableView<>();

        TableColumn team = new TableColumn("Team");
        team.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));

        TableColumn matchesPlayed = new TableColumn("Games Played");
        matchesPlayed.setCellValueFactory(new PropertyValueFactory<Team, String>("matchesPlayed"));

        TableColumn matchesWon = new TableColumn("Matches Won");
        matchesWon.setCellValueFactory(new PropertyValueFactory<Team, String>("matchesWon"));

        TableColumn setsWon = new TableColumn("Sets won");
        setsWon.setCellValueFactory(new PropertyValueFactory<Team, String>("setsWon"));

        tableStats.setItems(app.getTeams());

        tableStats.getColumns().addAll(team, matchesPlayed, matchesWon, setsWon);

        stats.getChildren().addAll(tableStats);

        return stats;
    }

    private VBox ranks() {
        VBox ranks = new VBox();
        ranks.setSpacing(5);

        TableView<Team> tableRanks = new TableView();

        TableColumn team = new TableColumn("Team");
        team.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));

        TableColumn rank = new TableColumn("Rank");
        rank.setCellValueFactory(new PropertyValueFactory<Team, String>("rank"));

        TableColumn matchesWon = new TableColumn("Matches Won");
        matchesWon.setCellValueFactory(new PropertyValueFactory<Team, String>("matchesWon"));
        
        tableRanks.setItems(app.getTeams());
        
        tableRanks.getColumns().addAll(team, matchesWon, rank);
        ranks.getChildren().addAll(tableRanks);
        return ranks;
    }

    private VBox matchScores() {
        VBox matchScores = new VBox();
        matchScores.setSpacing(5);

        ComboBox<Team> homeTeam = new ComboBox<>(app.getTeams());
        homeTeam.setPromptText("Home Team");

        ComboBox<Team> awayTeam = new ComboBox<>(app.getTeams());
        awayTeam.setPromptText("Away Team");

        TableView tableMatchScores = new TableView();
        TableColumn matchversus = new TableColumn("Match");
        TableColumn playerName = new TableColumn("Player Name");
        TableColumn scoreSingSet1 = new TableColumn("Set 1 Score");
        TableColumn scoreSingSet2 = new TableColumn("Set 2 Score");
        TableColumn scoreSingSet3 = new TableColumn("Set 3 Score");
        TableColumn scoreSingSet4 = new TableColumn("Set 4 Score");
        TableColumn scoreDobSet = new TableColumn("Double Set Score");
        tableMatchScores.getColumns().addAll(matchversus, playerName, scoreSingSet1, scoreSingSet2, scoreSingSet3, scoreSingSet4, scoreDobSet);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(homeTeam, awayTeam);

        matchScores.getChildren().addAll(hbox, tableMatchScores);
        return matchScores;
    }
}
