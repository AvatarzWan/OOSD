package oosd;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private final Core app = new Core();

    @Override
    public void start(Stage stage) {
        Group root = new Group();

        Scene scene = new Scene(root, 800, 800);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        

        BorderPane borderPane = new BorderPane();
        borderPane.setMaxWidth(Double.MAX_VALUE);

        Tab tabAdmin = new Tab();
        tabAdmin.setText("Admin");

        Admin admin = new Admin(app);
        tabAdmin.setContent(admin);
        tabPane.getTabs().add(tabAdmin);
        
        Tab tabViewer = new Tab();
        tabViewer.setText("Viewer");
        Viewer viewer = new Viewer(app);
        tabViewer.setContent(viewer);
        tabPane.getTabs().add(tabViewer);
        
        //Tab tabScore = new Tab();
        //tabScore.setText("Score Sheet");
        //Score score = new Score(app);
        //tabScore.setContent(score);
        //tabPane.getTabs().add(tabScore);
        
        

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        stage.setScene(scene);
        stage.show();

    }
}
