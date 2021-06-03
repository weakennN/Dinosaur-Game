package Game;

import ECS.Collider;
import ECS.Rigidbody;
import Engine.GameEngine;
import Game.Camera.GameCamera;
import Game.Common.GlobalVariables;
import Game.GameManager.GameManager;
import Game.GameObjects.Dinosaur.Dinosaur;
import Game.GameObjects.GameObject;
import Game.Input.Actions;
import Game.Input.Input;
import Game.Map.MapManager;
import UI.Designer;

import java.util.ArrayList;
import java.util.List;

public class DinosaurGame extends Game {

    public static List<GameObject> gameObjects = new ArrayList<>();
    private GameEngine engine;
    private Input input;
    private MapManager mapManager;
    private Dinosaur dinosaur;
    private GameManager speeder;

    public DinosaurGame() {

        this.destroyGameObjects();
        this.mapManager = new MapManager();
        Actions.initActions(this);
        this.input = new Input(this);
        this.input.initActions();
    }

    @Override
    public void start() {

        this.dinosaur = this.mapManager.getDinosaur();
        this.engine = new GameEngine(this);
        this.engine.setGameObjects(gameObjects);
        this.engine.setCamera(new GameCamera(this.dinosaur));
        this.engine.start();
    }

    @Override
    public void update() {

        if (GameState.running) {

            for (int i = 0; i < gameObjects.size(); i++) {

                GameObject gm = gameObjects.get(i);

                if (!gm.getTag().equals(GlobalVariables.DINOSAUR_TAG)) {

                    Collider collider = (Collider) gm.getComponent(Collider.class);

                    if (gm.getTransform().getPos().x + collider.getSize().x <= (this.dinosaur.getTransform().getPos().x - 300)) {

                        gm.destroy();
                    }

                }

            }

            if (this.dinosaur.isDead()) {

                this.stopGameObjects();
                Designer.restartButton.setVisible(true);
                Designer.gameOverImage.setVisible(true);
                this.input.stopInput();
                this.speeder.stop();
                GameState.running = false;
            }

            this.speeder.speedUp();
            this.mapManager.manage();
        }

    }

    public void initSpeader() {

        this.speeder = new GameManager(this.dinosaur);
    }

    public void stopGameObjects() {

        for (int i = 0; i < gameObjects.size(); i++) {

            GameObject gameObject = gameObjects.get(i);
            gameObject.removeComponent(Rigidbody.class);
        }

    }

    private void destroyGameObjects() {

        while (!gameObjects.isEmpty()) {

            gameObjects.get(0).destroy();
        }
    }

    @Override
    public void stop() {

        this.destroyGameObjects();
        gameObjects.clear();
        this.engine.stop();

    }

    public Dinosaur getDinosaur() {

        return this.dinosaur;
    }

    public Input getInput() {

        return this.input;
    }

}
