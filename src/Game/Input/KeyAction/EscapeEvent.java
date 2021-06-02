package Game.Input.KeyAction;

import Game.DinosaurGame;
import Game.GameState;
import UI.Designer;

public class EscapeEvent extends KeyEvent{

    public EscapeEvent(String type, int key) {
        super(type, key);
    }

    @Override
    public void run(DinosaurGame dinosaurGame) {

        GameState.paused = true;
        Designer.continueButton.setVisible(true);
        dinosaurGame.getInput().stopInput();
    }

}
