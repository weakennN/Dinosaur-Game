package Game.Sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;

public class SoundsManager {

    public static void playSound(String sound) {

        String path = null;
        try {
            path = SoundsManager.class.getResource("/Resources/SoundEffects/" + sound).toURI().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }

}
