package Game.GameObjects;

import ECS.Collider;
import ECS.Transform;
import Game.Animator.GlobalAnimations;
import Game.Common.GlobalVariables;
import Game.GameObjects.Dinosaur.Dinosaur;
import Game.GameObjects.Dinosaur.DinosaurState;
import Game.GameState;
import Game.Validator.Validator;

public class Ground extends GameObject {

    public Ground(String tag) {
        super(tag);

    }

    @Override
    public void start() {

        super.setCurrentAnimation(GlobalAnimations.GROUND);
    }

    @Override
    public void update() {

        super.updateComponents();
    }

    @Override
    public void onCollisionEnter(GameObject other) {

        if (other.getTag().equals(GlobalVariables.DINOSAUR_TAG)) {

            Dinosaur dinosaur = (Dinosaur) other;

            Collider groundCollider = (Collider) super.getComponent(Collider.class);
            Collider dinosaurCollider = (Collider) other.getComponent(Collider.class);

            if (!Validator.isNull(dinosaur.getRigidbody()) && !Validator.isNull(groundCollider) && !Validator.isNull(dinosaurCollider)) {

                dinosaur.getTransform().getPos().y = groundCollider.getPos().y - dinosaurCollider.getSize().y;
                dinosaur.getRigidbody().getVel().y = 0;
                dinosaur.getRigidbody().getAcc().y = 0;
                dinosaur.setJumping(false);
                dinosaur.setRunning(true);
                dinosaur.getManager().changeToRun();
            }

        }

    }

}
