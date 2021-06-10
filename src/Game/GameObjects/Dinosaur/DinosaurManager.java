package Game.GameObjects.Dinosaur;

import ECS.Animator.Animator;
import ECS.Collider;
import ECS.Rigidbody;
import Game.Sound.Sounds;
import Game.Sound.SoundsManager;
import Game.Validator.Validator;

public class DinosaurManager {

    private Dinosaur dinosaur;

    public DinosaurManager(Dinosaur dinosaur) {

        this.dinosaur = dinosaur;
    }

    public void killDinosaur() {

        this.dinosaur.getComponent(Animator.class).getAnimationController().playAnimation("dead");
        SoundsManager.playSound(Sounds.DINOSAUR_DEAD);
        this.dinosaur.setDead(true);
        this.dinosaur.removeComponent(Rigidbody.class);
        Collider.colliders.remove(dinosaur.getComponent(Collider.class));
        this.dinosaur.removeComponent(Collider.class);
        this.dinosaur.removeComponent(Animator.class);

    }

    public void changeCollider(double sizeX, double sizeY) {

        Collider collider = this.dinosaur.getComponent(Collider.class);

        if (!Validator.isNull(collider)) {

            collider.resize(sizeX, sizeY);
        }

    }

    public void changeToRun() {

        if (this.dinosaur.isRunning()) {

            if (!DinosaurState.running) {
                this.dinosaur.getComponent(Animator.class).getAnimationController().playAnimation("running");
                DinosaurState.running = true;
            }

        }

    }

}
