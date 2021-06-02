package Game.Input;

import Game.DinosaurGame;
import Game.Input.KeyAction.*;
import UI.Designer;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private DinosaurGame dinosaurGame;
    private List<KeyEvent> keyPressedEvents;
    private List<KeyEvent> keyReleasedEvents;

    public Input(DinosaurGame dinosaurGame) {

        this.dinosaurGame = dinosaurGame;
        this.initKeyPressedEvents();
        this.initKeyReleasedEvents();
    }

    public void initActions() {

        Designer.scene.setOnKeyPressed(e -> {

            this.performEvent(e.getCode().getCode(), this.keyPressedEvents);

        });

        Designer.scene.setOnKeyReleased(e -> {

            this.performEvent(e.getCode().getCode(), this.keyReleasedEvents);

        });

    }

    private void performEvent(int key, List<KeyEvent> events) {

        for (KeyEvent event : events) {

            if (event.getKey() == key) {

                event.run(this.dinosaurGame);
            }

        }

    }

    private void initKeyPressedEvents() {

        this.keyPressedEvents = new ArrayList<>();

        this.keyPressedEvents.add(new JumpEvent("jump", KeyCode.W.getCode()));
        this.keyPressedEvents.add(new CrouchEvent("crouch", KeyCode.S.getCode()));
        this.keyPressedEvents.add(new EscapeEvent("pause", KeyCode.ESCAPE.getCode()));

    }

    private void initKeyReleasedEvents() {

        this.keyReleasedEvents = new ArrayList<>();

        this.keyReleasedEvents.add(new CrouchReleasedEvent("releasedCrouch", KeyCode.S.getCode()));
    }

    public void stopInput() {

        Designer.scene.setOnKeyPressed(null);
        Designer.scene.setOnKeyReleased(null);
    }

}
