package Game.Map;

import ECS.Collider;
import ECS.Rigidbody;
import ECS.Transform;
import Game.Common.GlobalVariables;
import Game.GameObjectFactory.GameObjectFactory;
import Game.GameObjects.Dinosaur.Dinosaur;
import Game.GameObjects.Ground;
import UI.Designer;
import mikera.vectorz.Vector2;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LevelMaker {

    private GameObjectFactory gameObjectFactory;
    private List<Double> spaceInBetween;
    private ThreadLocalRandom random;
    private Dinosaur dinosaur;

    public LevelMaker() {

        this.gameObjectFactory = new GameObjectFactory();
        this.spaceInBetween = List.of(Designer.scene.getWidth(),
                Designer.scene.getWidth() + 100, Designer.scene.getWidth() + 250);
        this.random = ThreadLocalRandom.current();
    }

    public void initStartObjects() {

        Transform transform = new Transform(new Vector2(GlobalVariables.DEFAULT_DINOSAUR_POS_X, GlobalVariables.DEFAULT_DINOSAUR_POS_Y));
        this.dinosaur = new Dinosaur(GlobalVariables.DINOSAUR_TAG, transform);
        this.dinosaur.addComponent(new Rigidbody(this.dinosaur));
        this.dinosaur.addComponent(new Collider(this.dinosaur, GlobalVariables.DINOSAUR_SIZE_X, GlobalVariables.DINOSAUR_SIZE_Y));
        this.dinosaur.setActive(true);

        this.createGround(0, GlobalVariables.GROUND_POS_Y);
    }

    public void createRandomGameObject(double posX, double posY) {

        this.gameObjectFactory.getGameObjectCreators().get(this.random.nextInt(0,
                this.gameObjectFactory.getGameObjectCreators().size())).createObject(posX, posY);
    }

    public double getRandomSpace() {

        return this.spaceInBetween.get(this.random.nextInt(0, this.spaceInBetween.size()));
    }

    public void createGround(double posX, double posY) {

        Ground ground = new Ground(GlobalVariables.GROUND_TAG, new Transform(new Vector2(posX, posY)));
        ground.addComponent(new Collider(ground, GlobalVariables.GROUND_SIZE_X, GlobalVariables.GROUND_SIZE_Y, new Transform(new Vector2(posX, posY + 20))));
        ground.setActive(true);
        ground.start();
    }

    public Dinosaur getDinosaur() {

        return this.dinosaur;
    }

}
