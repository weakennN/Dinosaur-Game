package Game.ObjectCreators;

import ECS.Collider;
import ECS.Rigidbody;
import ECS.Transform;
import Game.Common.GlobalVariables;
import Game.GameObjects.Bat;
import mikera.vectorz.Vector2;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BatCreator extends GameObjectCreator {

    private List<Double> randomPos;

    public BatCreator() {

        super();
        this.randomPos = List.of(575.0, 545.0, 525.0);
    }

    @Override
    public void createObject(double posX, double posY) {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Bat bat = new Bat(GlobalVariables.BAT_TAG);
        bat.addComponent(new Transform(new Vector2(posX, this.randomPos.get(random.nextInt(0, this.randomPos.size()))), bat));
        bat.addComponent(new Rigidbody(bat, false));
        bat.addComponent(new Collider(bat, GlobalVariables.BAT_SIZE_X, GlobalVariables.BAT_SIZE_Y));
        bat.setActive(true);
        bat.start();
    }

}
