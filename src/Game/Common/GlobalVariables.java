package Game.Common;

import Game.Animator.GlobalAnimations;
import javafx.scene.image.Image;

public class GlobalVariables {

    public final static String DINOSAUR_TAG = "dinosaur";
    public final static String CACTUS_TAG = "cactus";
    public final static String BAT_TAG = "bat";
    public final static String GROUND_TAG = "ground";
    public final static double DINOSAUR_SIZE_X = 50;
    public final static double DINOSAUR_SIZE_Y = 50;
    public final static double GROUND_SIZE_Y = 50;
    public final static double SINGLE_CACTUS_SIZE_X = 28;
    public final static double SINGLE_CACTUS_SIZE_Y = 60;
    public final static Image background = new Image(GlobalAnimations.IMAGE_PATH + GlobalAnimations.GROUND);
    public final static double GROUND_SIZE_X = background.getWidth();
    public final static double DOUBLE_CACTUS_SIZE_X = 60;
    public final static double DOUBLE_CACTUS_SIZE_Y = 60;
    public final static double GROUND_POS_Y = 600;
    public final static double TRIPLE_CACTUS_SIZE_X = 92;
    public final static double TRIPLE_CACTUS_SIZE_Y = 65;
    public final static double DEFAULT_DINOSAUR_POS_X = 0;
    public final static double DEFAULT_DINOSAUR_POS_Y = 565;
    public final static double BAT_SIZE_X = 45;
    public final static double BAT_SIZE_Y = 25;
    public final static double DINOSAUR_CROUCH_SIZE_X = 60;
    public final static double DINOSAUR_CROUCH_SIZE_Y = 40;
    public final static String HIGH_SCORE_LABEL_DEFAULT_TEXT = "HI ";
    public static final String BACKGROUND_SORTING_LAYER = "background";
    public static final String DEFAULT_SORTING_LAYER = "default";

}
