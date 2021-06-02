import Game.DinosaurGame;
import UI.Designer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Scene scene = Designer.createScene();

        DinosaurGame dinosaurGame = new DinosaurGame();

        stage.setMaximized(true);
        stage.setTitle("Dinosaur Game");
        stage.setScene(scene);
        stage.show();

        dinosaurGame.start();
    }
}
