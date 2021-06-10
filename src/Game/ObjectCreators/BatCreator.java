package Game.ObjectCreators;

import ECS.*;
import ECS.Animator.Animation;
import ECS.Animator.AnimationController;
import ECS.Animator.Animator;
import ECS.SprtieRenderer.SpriteRenderer;
import ECS.SprtieRenderer.SpriteSheet;
import Game.Animator.GlobalAnimations;
import Game.Common.GlobalSpriteSheets;
import Game.Common.GlobalVariables;
import Game.GameObjects.Bat;
import mikera.vectorz.Vector2;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BatCreator extends GameObjectCreator {

    private List<Double> randomPos;

    public BatCreator() {

        super();
        this.randomPos = List.of(575.0, 545.0, 525.0);
    }

    @Override
    public void createObject(double posX, double posY) {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Bat bat = new Bat(GlobalVariables.BAT_TAG);
        bat.addComponent(new Transform(new Vector2(posX, this.randomPos.get(random.nextInt(0, this.randomPos.size()))), bat));
        bat.addComponent(new Rigidbody(bat, false));
        bat.addComponent(new Collider(bat, GlobalVariables.BAT_SIZE_X, GlobalVariables.BAT_SIZE_Y, bat.getTransform()));
        SpriteSheet spriteSheet = GlobalSpriteSheets.spriteSheets.get(GlobalAnimations.BAT_SPRITE);
        bat.addComponent(new SpriteRenderer(bat, spriteSheet));
        AnimationController animationController = new AnimationController();
        animationController.createAnimation("default", new Animation(List.of(spriteSheet.getSprites().get(0), spriteSheet.getSprites().get(1)), 25, bat));
        bat.addComponent(new Animator(bat, animationController));
        bat.getComponent(Animator.class).getAnimationController().playAnimation("default");
        bat.setActive(true);
        bat.start();
    }

}
