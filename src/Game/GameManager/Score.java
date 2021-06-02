package Game.GameManager;

import javafx.animation.AnimationTimer;

public class Score {

    private int points;
    private int period;
    private AnimationTimer time;

    public Score() {

        this.period = 20;

        this.time = new AnimationTimer() {

            private int frames = 0;

            @Override
            public void handle(long l) {

                if (frames++ >= period) {

                    points++;
                    frames = 0;
                }
            }

        };

        this.time.start();

    }

    public int getPoints() {

        return this.points;

    }

    public int getPeriod() {

        return this.period;

    }

    public void setPeriod(int period) {

        this.period = period;

    }

    public void stop() {

        this.time.stop();

    }

}
