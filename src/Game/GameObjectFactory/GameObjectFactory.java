package Game.GameObjectFactory;

import Game.Animator.GlobalAnimations;
import Game.Common.GlobalVariables;
import Game.ObjectCreators.BatCreator;
import Game.ObjectCreators.CactusCreator;
import Game.ObjectCreators.GameObjectCreator;

import java.util.ArrayList;
import java.util.List;

public class GameObjectFactory {

    private List<GameObjectCreator> gameObjectCreators;

    public GameObjectFactory() {

        this.gameObjectCreators = new ArrayList<>();
        this.initCreators();
    }

    private void initCreators() {

        this.gameObjectCreators.add(new CactusCreator(GlobalVariables.SINGLE_CACTUS_SIZE_X
                , GlobalVariables.SINGLE_CACTUS_SIZE_Y, GlobalAnimations.SINGLE_CACTUS));

        this.gameObjectCreators.add(new CactusCreator(GlobalVariables.DOUBLE_CACTUS_SIZE_X
                , GlobalVariables.DOUBLE_CACTUS_SIZE_Y, GlobalAnimations.DOUBLE_CACTUS));

        this.gameObjectCreators.add(new CactusCreator(GlobalVariables.TRIPLE_CACTUS_SIZE_X,
                GlobalVariables.TRIPLE_CACTUS_SIZE_Y, GlobalAnimations.TRIPLE_CACTUS));

        this.gameObjectCreators.add(new BatCreator());

    }

    public List<GameObjectCreator> getGameObjectCreators() {

        return this.gameObjectCreators;
    }

}
