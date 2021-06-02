package Game.GameObjects.Dinosaur;

import ECS.Collider;
import ECS.Rigidbody;
import Game.Animator.GlobalAnimations;
import Game.Sound.Sounds;
import Game.Sound.SoundsManager;
import Game.Validator.Validator;

public class DinosaurManager {

    private Dinosaur dinosaur;

    public DinosaurManager(Dinosaur dinosaur) {

        this.dinosaur = dinosaur;
    }

    public void killDinosaur() {

        this.dinosaur.setCurrentAnimation(GlobalAnimations.DINOSAUR_DEAD);
        SoundsManager.playSound(Sounds.DINOSAUR_DEAD);
        this.dinosaur.setDead(true);
        this.dinosaur.removeComponent(Rigidbody.class);
        Collider.colliders.remove((Collider) dinosaur.getComponent(Collider.class));
        this.dinosaur.removeComponent(Collider.class);

    }

    public void changeCollider(double sizeX, double sizeY) {

        Collider collider = (Collider) this.dinosaur.getComponent(Collider.class);

        if (!Validator.isNull(collider)) {

            collider.resize(sizeX, sizeY);
        }

    }

    public void changeToRun() {

        if (this.dinosaur.isRunning()) {

            if (!DinosaurState.running) {

                this.dinosaur.setCurrentAnimation(GlobalAnimations.DINOSAUR_RUNNING);
                DinosaurState.running = true;
            }

        }

    }

}
