package Game.Map;

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

        if (dinosaur.getTransform().getPos().x >= (this.endX - Designer.scene.getWidth())) {

            this.levelMaker.createGround(this.endX, GlobalVariables.GROUND_POS_Y);
            this.endX += GlobalVariables.GROUND_SIZE_X;
        }

        if (this.dinosaur.getTransform().getPos().x >= 600 + this.spaceX) {

            this.levelMaker.createRandomGameObject(this.dinosaur.getTransform().getPos().x + Designer.scene.getWidth(), GlobalVariables.GROUND_POS_Y);
            this.spaceX += this.levelMaker.getRandomSpace();

        }

    }

    public Dinosaur getDinosaur() {

        return this.dinosaur;
    }

}
