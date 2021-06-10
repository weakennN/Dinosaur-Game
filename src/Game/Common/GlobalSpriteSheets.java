package Game.Common;

import ECS.SprtieRenderer.SpriteSheet;
import Game.Animator.GlobalAnimations;

import java.util.HashMap;
import java.util.Map;

public class GlobalSpriteSheets {

    public static Map<String, SpriteSheet> spriteSheets = new HashMap<>();

    public static void initSpriteSheets() {

        spriteSheets.put(GlobalAnimations.BAT_SPRITE, new SpriteSheet(GlobalAnimations.BAT_SPRITE, 50, 35, 0));
        spriteSheets.put(GlobalAnimations.DINO_SPRITE, new SpriteSheet(GlobalAnimations.DINO_SPRITE, 50, 53, 0));
        spriteSheets.put(GlobalAnimations.DINO_CROUCH_SPRITE, new SpriteSheet(GlobalAnimations.DINO_CROUCH_SPRITE, 65, 39, 0));
    }
}
