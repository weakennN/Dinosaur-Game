package Game.Input.KeyAction;

import Game.DinosaurGame;

public abstract class KeyEvent {

    private String type;
    private int key;

    public KeyEvent(String type, int key) {

        this.type = type;
        this.key = key;
    }

    public abstract void run(DinosaurGame dinosaurGame);

    public int getKey() {

        return this.key;
    }

}
