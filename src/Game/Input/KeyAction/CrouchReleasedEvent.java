package Game.Input.KeyAction;

import ECS.Animator;
import Game.Animator.GlobalAnimations;
import Game.Common.GlobalVariables;
import Game.DinosaurGame;

public class CrouchReleasedEvent extends KeyEvent{

    public CrouchReleasedEvent(String type, int key) {
        super(type, key);
    }

    @Override
    public void run(DinosaurGame dinosaurGame) {

        if (!dinosaurGame.getDinosaur().isJumping() && !dinosaurGame.getDinosaur().isDead()) {

            dinosaurGame.getDinosaur().getComponent(Animator.class).getAnimationController().playAnimation("running");
            dinosaurGame.getDinosaur().setCrouching(false);
            dinosaurGame.getDinosaur().getManager().changeCollider(GlobalVariables.DINOSAUR_SIZE_X, GlobalVariables.DINOSAUR_SIZE_Y);
        } else {

            if (dinosaurGame.getDinosaur().getRigidbody() != null) {

                dinosaurGame.getDinosaur().getRigidbody().getAcc().y = 0;
            }

        }

    }

}
