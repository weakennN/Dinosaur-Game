package Game.Input.KeyAction;

import Game.Animator.GlobalAnimations;
import Game.Common.GlobalVariables;
import Game.DinosaurGame;

public class CrouchEvent extends KeyEvent {

    public CrouchEvent(String type, int key) {
        super(type, key);
    }

    @Override
    public void run(DinosaurGame dinosaurGame) {

        if (!dinosaurGame.getDinosaur().isJumping() && !dinosaurGame.getDinosaur().isCrouching()) {

            dinosaurGame.getDinosaur().setCrouching(true);
            dinosaurGame.getDinosaur().setCurrentAnimation(GlobalAnimations.DINOSAUR_CROUCH);
            dinosaurGame.getDinosaur().getManager().changeCollider(GlobalVariables.DINOSAUR_CROUCH_SIZE_X, GlobalVariables.DINOSAUR_CROUCH_SIZE_Y);
        } else {

            dinosaurGame.getDinosaur().getRigidbody().getAcc().y += 0.5;
        }

    }

}

