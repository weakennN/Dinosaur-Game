package Engine;

import Game.Camera.Camera;
import Game.GameObjects.GameObject;
import Game.Game;
import Renderer.Renderer;
import javafx.animation.AnimationTimer;
import Game.GameState;

import java.util.List;

public class GameEngine extends Engine {

    private List<GameObject> gameObjects;
    private AnimationTimer gameLoop;
    public static Camera camera;
    private Game game;

    public GameEngine(Game game) {

        this.game = game;
    }

    @Override
    public void start() {

        this.gameLoop = new AnimationTimer() {

            @Override
            public void handle(long l) {

                if (GameState.paused) {

                    return;
                }

                Renderer.clear();
                game.update();

                for (int i = 0; i < gameObjects.size(); i++) {

                    GameObject gameObject = gameObjects.get(i);

                    if (gameObject == null) {

                        continue;
                    }

                    if (gameObject.isActive()) {

                        gameObject.update();
                        Renderer.render(gameObject.render(), gameObject.getTransform());
                    }

                }

                camera.followTarget();

            }

        };

        this.gameLoop.start();

    }

    @Override
    public void stop() {

        gameObjects.clear();
        this.gameLoop.stop();
    }

    public void setCamera(Camera camera1) {

        camera = camera1;
    }

    public Camera getCamera() {

        return camera;
    }

    public void setGameObjects(List<GameObject> gameObjects) {

        this.gameObjects = gameObjects;
    }

}
