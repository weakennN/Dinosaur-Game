package Game.Sound;

import javafx.scene.media.AudioClip;

import java.io.File;

public class SoundsManager {

    private static AudioClip audioClip;

    public static void playSound(String sound) {

        File file = new File(Sounds.SOUND_PATH + sound);
        audioClip = new AudioClip(file.toURI().toString());
        audioClip.setVolume(0.25);
        audioClip.play();

    }

}
