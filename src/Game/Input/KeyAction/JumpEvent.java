package Game.Input.KeyAction;

import Game.DinosaurGame;
import Game.GameState;
import Game.Sound.Sounds;
import Game.Sound.SoundsManager;

public class JumpEvent extends KeyEvent {

    public JumpEvent(String type, int key) {
        super(type, key);
    }

    @Override
    public void run(DinosaurGame dinosaurGame) {

        if (!GameState.running) {

            SoundsManager.playSound(Sounds.DINOSAUR_JUMP);
            dinosaurGame.initSpeader();
            dinosaurGame.getDinosaur().start();
            dinosaurGame.getDinosaur().jump();
            GameState.running = true;
        } else {

            if (!dinosaurGame.getDinosaur().isJumping() && !dinosaurGame.getDinosaur().isCrouching()) {

                SoundsManager.playSound(Sounds.DINOSAUR_JUMP);
                dinosaurGame.getDinosaur().jump();
            }

        }

    }

}
