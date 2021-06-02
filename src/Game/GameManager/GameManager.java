package Game.GameManager;

import ECS.Rigidbody;
import Game.Common.GlobalVariables;
import Game.GameObjects.Dinosaur.Dinosaur;
import Game.Validator.Validator;
import UI.Designer;

public class GameManager {

    private Dinosaur dinosaur;
    private double speedingPos;
    private Score score;

    public GameManager(Dinosaur dinosaur) {

        this.dinosaur = dinosaur;
        this.speedingPos = dinosaur.getTransform().getPos().x + 2000;
        this.score = new Score();
    }

    public void speedUp() {

        Designer.scoreLabel.setText(this.score.getPoints() + "");

        if (dinosaur.getTransform().getPos().x > this.speedingPos
                && !Validator.isNull(this.dinosaur.getRigidbody()) && this.dinosaur.getRigidbody().getVel().x <= 15.5) {

            Rigidbody rigidbody = dinosaur.getRigidbody();
            rigidbody.getVel().x += 0.5;

            this.speedingPos += 2000;
            this.score.setPeriod(this.score.getPeriod() - 1);

        }

    }

    public void stop() {

        Designer.highScore.setVisible(true);
        this.score.stop();
        HighScoreContainer.setHighScore(this.score.getPoints());
        Designer.highScore.setText(GlobalVariables.HIGH_SCORE_LABEL_DEFAULT_TEXT + HighScoreContainer.highScore + "");
        Designer.scoreLabel.setText("");

    }

}
