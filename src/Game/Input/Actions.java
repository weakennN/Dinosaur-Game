package Game.Input;

import Engine.GameEngine;
import Game.GameState;
import UI.Designer;
import Game.DinosaurGame;

public class Actions {

    public static void initActions(DinosaurGame game) {

        Designer.restartButton.setOnAction(e -> {

            game.stop();
            Designer.restartButton.setVisible(false);
            Designer.gameOverImage.setVisible(false);
            GameEngine.camera.restartCamera();
            DinosaurGame dinosaurGame = new DinosaurGame();
            Designer.scoreLabel.setText("");
            dinosaurGame.start();

        });

        Designer.continueButton.setOnAction(e -> {

            GameState.paused = false;
            Designer.continueButton.setVisible(false);
            game.getInput().initActions();
        });

    }

}
