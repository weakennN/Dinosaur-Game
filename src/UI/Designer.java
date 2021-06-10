package UI;

import Game.Animator.GlobalAnimations;
import Game.Common.GlobalVariables;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Designer {

    public static Canvas canvas;
    public static GraphicsContext gc;
    public static Label scoreLabel;
    public static Label highScore;
    public static Scene scene;
    public static Pane root;
    public static Button restartButton = new Button();
    public static Button continueButton = new Button();
    public static HBox buttonsBox = new HBox(20);
    public static ImageView gameOverImage;

    public static Scene createScene() {

        root = new Pane();
        canvas = new Canvas(1920, 1080);
        gc = canvas.getGraphicsContext2D();

        gameOverImage = new ImageView(GlobalAnimations.IMAGE_PATH + GlobalAnimations.GAME_OVER);

        scene = new Scene(root, 1920, 1080);

        initButtons();
        initLabels();

        root.getChildren().addAll(canvas, restartButton, gameOverImage, buttonsBox, continueButton);

        gameOverImage.setLayoutY(restartButton.getLayoutY() - 80);
        gameOverImage.setLayoutX(restartButton.getLayoutX() - (gameOverImage.getImage().getWidth() / 2) + 20);
        gameOverImage.setVisible(false);

        return scene;
    }

    private static void initButtons() {

        Button[] buttons = {restartButton, continueButton};

        for (Button button : buttons) {

            button.setStyle("-fx-background-color: transparent");
            button.setVisible(false);
            button.setLayoutX(Designer.scene.getWidth() / 2);
            button.setLayoutY(Designer.scene.getHeight() / 2);

        }

        ImageView imageView = new ImageView(new Image(GlobalAnimations.IMAGE_PATH + GlobalAnimations.RESTART_BUTTON));
        ImageView imgV = new ImageView(new Image(GlobalAnimations.IMAGE_PATH + GlobalAnimations.CONTINUE_BUTTON));

        restartButton.setGraphic(imageView);
        continueButton.setGraphic(imgV);
    }

    private static void initLabels() {

        scoreLabel = new Label();
        highScore = new Label(GlobalVariables.HIGH_SCORE_LABEL_DEFAULT_TEXT);
        highScore.setVisible(false);

        buttonsBox.getChildren().addAll(scoreLabel, highScore);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setLayoutY(5);

        Font font = Font.loadFont(Designer.class.getResourceAsStream("/Resources/Font/defaultFont.ttf"),15);

        scoreLabel.setFont(font);
        highScore.setFont(font);

    }

}
