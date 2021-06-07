package Game.GameObjects;

import ECS.Rigidbody;

public class Bat extends GameObject {

    public Bat(String tag) {
        super(tag);

    }

    @Override
    public void start() {

        super.start();

        Rigidbody rigidbody = super.getComponent(Rigidbody.class);
        rigidbody.getVel().x = -2;
    }

    @Override
    public void update() {

        super.updateComponents();
    }

    @Override
    public void onCollisionEnter(GameObject other) {

    }

}
