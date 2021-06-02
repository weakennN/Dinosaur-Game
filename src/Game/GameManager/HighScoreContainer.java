package Game.GameManager;

public class HighScoreContainer {

    public static int highScore = 0;

    public static void setHighScore(int highScore_) {

        if (highScore < highScore_) {

            highScore = highScore_;
        }

    }

}
