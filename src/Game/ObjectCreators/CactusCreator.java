package Game.ObjectCreators;

import ECS.Collider;
import ECS.Transform;
import Game.Common.GlobalVariables;
import Game.GameObjects.Cactus;
import mikera.vectorz.Vector2;

import java.util.concurrent.ThreadLocalRandom;

public class CactusCreator extends GameObjectCreator {

    private String animation;
    private double sizeX;
    private double sizeY;
    private ThreadLocalRandom random;

    public CactusCreator(double sizeX, double sizeY, String animation) {

        super();

        this.animation = animation;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.random = ThreadLocalRandom.current();
    }

    @Override
    public void createObject(double posX, double posY) {

        Cactus cactus = new Cactus(GlobalVariables.CACTUS_TAG, this.animation);
        cactus.addComponent(new Transform(new Vector2(posX, GlobalVariables.GROUND_POS_Y + 20 - this.sizeY), cactus));
        cactus.addComponent(new Collider(cactus, this.sizeX, this.sizeY, cactus.getTransform()));
        Transform transform = cactus.getTransform();
        double randomScale = this.getRandomScale();
        transform.setScale(new Vector2(randomScale, randomScale));
        transform.setPos(new Vector2(posX, GlobalVariables.GROUND_POS_Y + 20 - ((Collider) cactus.getComponent(Collider.class)).getSize().y));
        cactus.start();

    }

    private double getRandomScale() {

        return this.random.nextDouble(0.6, 1.2);
    }

}
