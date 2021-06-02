package Game.Map;

import ECS.Transform;
import Game.Common.GlobalVariables;
import Game.GameObjects.Dinosaur.Dinosaur;
import UI.Designer;

public class MapManager {

    private Dinosaur dinosaur;
    private double endX;
    private double spaceX;
    private LevelMaker levelMaker;

    public MapManager() {

        this.levelMaker = new LevelMaker();
        this.endX = GlobalVariables.GROUND_SIZE_X;
        this.initGameObjects();
        this.dinosaur = this.levelMaker.getDinosaur();
    }

    private void initGameObjects() {

        this.levelMaker.initStartObjects();

    }

    public void manage() {

        Transform transform = (Transform) this.dinosaur.getComponent(Transform.class);

        if (transform.getPos().x >= (this.endX - Designer.scene.getWidth())) {

            this.levelMaker.createGround(this.endX, GlobalVariables.GROUND_POS_Y);
            this.endX += GlobalVariables.GROUND_SIZE_X;
        }

        if (transform.getPos().x >= 600 + this.spaceX) {

            this.levelMaker.createRandomGameObject(transform.getPos().x + Designer.scene.getWidth(), GlobalVariables.GROUND_POS_Y);
            this.spaceX += this.levelMaker.getRandomSpace();

        }

    }

    public Dinosaur getDinosaur() {

        return this.dinosaur;
    }

}
