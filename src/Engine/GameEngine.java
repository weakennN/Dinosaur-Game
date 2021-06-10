package Engine;

import ECS.Collider;
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
    private Renderer renderer;
    private Game game;

    public GameEngine(Game game) {

        this.renderer = new Renderer();
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

                renderer.clear();
                game.update();

                updateGameObjects();

                detectCollision();

                renderer.render();
                camera.followTarget();

            }

        };

        this.gameLoop.start();

    }

    private void updateGameObjects() {

        for (int i = 0; i < gameObjects.size(); i++) {

            GameObject gameObject = gameObjects.get(i);

            if (gameObject.isActive()) {

                gameObject.update();
            }
        }
    }

    private void detectCollision() {

        for (int i = 0; i < Collider.colliders.size(); i++) {

            Collider collider = Collider.colliders.get(i);

            for (int j = 0; j < Collider.colliders.size(); j++) {

                if (collider == Collider.colliders.get(j)) {
                    continue;
                }

                if (collider.checkCollision(Collider.colliders.get(j))) {

                    collider.getGameObject().onCollisionEnter(Collider.colliders.get(j).getGameObject());
                }
            }

        }
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
