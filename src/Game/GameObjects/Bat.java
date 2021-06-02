package Game.GameObjects;

import ECS.Rigidbody;
import ECS.Transform;
import Game.Animator.GlobalAnimations;

public class Bat extends GameObject {

    public Bat(String tag) {
        super(tag);

    }

    @Override
    public void start() {

        super.setCurrentAnimation(GlobalAnimations.BAT);

        Rigidbody rigidbody = (Rigidbody) super.getComponent(Rigidbody.class);
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
