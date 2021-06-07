package Game.Common;

import ECS.SpriteSheet;
import Game.Animator.GlobalAnimations;

import java.util.HashMap;
import java.util.Map;

public class GlobalSpriteSheets {

    public static Map<String, SpriteSheet> spriteSheets = new HashMap<>();

    public static void initSpriteSheets() {

        spriteSheets.put(GlobalAnimations.IMAGE_PATH + "batSprite.png", new SpriteSheet(GlobalAnimations.IMAGE_PATH + "batSprite.png", 50, 35, 0));
        spriteSheets.put(GlobalAnimations.IMAGE_PATH + "testSprite.png", new SpriteSheet(GlobalAnimations.IMAGE_PATH + "testSprite.png", 50, 53, 0));
        spriteSheets.put(GlobalAnimations.IMAGE_PATH + "dinoCrouch.png", new SpriteSheet(GlobalAnimations.IMAGE_PATH + "dinoCrouch.png", 65, 39, 0));
    }
}
