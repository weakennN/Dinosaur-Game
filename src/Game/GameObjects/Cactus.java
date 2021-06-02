package Game.GameObjects;

import ECS.Transform;

public class Cactus extends GameObject {

    public Cactus(String tag, Transform transform, String animation) {
        super(tag, transform);

        super.setCurrentAnimation(animation);
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

        super.updateComponents();
    }

    @Override
    public void onCollisionEnter(GameObject other) {


    }

}
