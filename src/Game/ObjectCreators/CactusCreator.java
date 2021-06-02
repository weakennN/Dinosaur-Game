package Game.ObjectCreators;

import ECS.Collider;
import ECS.Transform;
import Game.Common.GlobalVariables;
import Game.GameObjects.Cactus;
import mikera.vectorz.Vector2;

public class CactusCreator extends GameObjectCreator {

    private String animation;
    private double sizeX;
    private double sizeY;

    // TODO: later on add logic for random sizes etc

    public CactusCreator(double sizeX, double sizeY, String animation) {

        super();

        this.animation = animation;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    @Override
    public void createObject(double posX, double posY) {

        Cactus cactus = new Cactus(GlobalVariables.CACTUS_TAG, new Transform(new Vector2(posX, GlobalVariables.GROUND_POS_Y + 20 - this.sizeY)), this.animation);
        cactus.addComponent(new Collider(cactus, this.sizeX, this.sizeY));
        cactus.setActive(true);
        cactus.start();
    }

}
