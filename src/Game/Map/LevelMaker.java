package Game.Map;

import ECS.*;
import Game.Animator.GlobalAnimations;
import Game.Common.GlobalSpriteSheets;
import Game.Common.GlobalVariables;
import Game.GameObjectFactory.GameObjectFactory;
import Game.GameObjects.Dinosaur.Dinosaur;
import Game.GameObjects.Ground;
import UI.Designer;
import javafx.scene.image.Image;
import mikera.vectorz.Vector2;

import java.awt.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LevelMaker {

    private GameObjectFactory gameObjectFactory;
    private List<Double> spaceInBetween;
    private ThreadLocalRandom random;
    private Dinosaur dinosaur;

    public LevelMaker() {

        GlobalSpriteSheets.initSpriteSheets();
        this.gameObjectFactory = new GameObjectFactory();
        this.spaceInBetween = List.of(Designer.scene.getWidth(),
                Designer.scene.getWidth() + 100, Designer.scene.getWidth() + 250);
        this.random = ThreadLocalRandom.current();
    }

    public void initStartObjects() {

        this.dinosaur = new Dinosaur(GlobalVariables.DINOSAUR_TAG);
        Transform transform = new Transform(new Vector2(GlobalVariables.DEFAULT_DINOSAUR_POS_X, GlobalVariables.DEFAULT_DINOSAUR_POS_Y), dinosaur);
        this.dinosaur.addComponent(transform);
        this.dinosaur.addComponent(new Rigidbody(this.dinosaur));
        this.dinosaur.addComponent(new Collider(this.dinosaur, GlobalVariables.DINOSAUR_SIZE_X, GlobalVariables.DINOSAUR_SIZE_Y, dinosaur.getTransform()));
        this.dinosaur.addComponent(new SpriteRenderer(dinosaur, GlobalSpriteSheets.spriteSheets.get(GlobalAnimations.DINO_SPRITE)));

        AnimationController animationController = new AnimationController();
        animationController.createAnimation("running", new Animation(List.of(this.dinosaur.getComponent(SpriteRenderer.class).getSprites().get(2),
                this.dinosaur.getComponent(SpriteRenderer.class).getSprites().get(3)), 13, this.dinosaur));
        animationController.createAnimation("idleAndJumping", new Animation(List.of(this.dinosaur.getComponent(SpriteRenderer.class).
                getSpriteSheet().getSprites().get(0)), 13, this.dinosaur));
        animationController.createAnimation("dead", new Animation(List.of(this.dinosaur.getComponent(SpriteRenderer.class).getSprites().get(4)), 13, this.dinosaur));
        animationController.createAnimation("crouch", new Animation(List.of(GlobalSpriteSheets.spriteSheets.get(GlobalAnimations.DINO_CROUCH_SPRITE).getSprites().get(0),
                GlobalSpriteSheets.spriteSheets.get(GlobalAnimations.DINO_CROUCH_SPRITE).getSprites().get(1)), 13, this.dinosaur));

        this.dinosaur.addComponent(new Animator(this.dinosaur, animationController));
        this.dinosaur.getComponent(Animator.class).getAnimationController().playAnimation("idleAndJumping");

        this.createGround(0, GlobalVariables.GROUND_POS_Y);
    }

    public void createRandomGameObject(double posX, double posY) {

        this.gameObjectFactory.getGameObjectCreators().get(this.random.nextInt(0,
                this.gameObjectFactory.getGameObjectCreators().size())).createObject(posX, posY);
    }

    public double getRandomSpace() {

        return this.spaceInBetween.get(this.random.nextInt(0, this.spaceInBetween.size()));
    }

    public void createGround(double posX, double posY) {


        Ground ground = new Ground(GlobalVariables.GROUND_TAG);
        Transform transform = new Transform(new Vector2(posX, posY), ground);
        ground.addComponent(transform);
        ground.addComponent(new Collider(ground, GlobalVariables.GROUND_SIZE_X, GlobalVariables.GROUND_SIZE_Y, new Transform(new Vector2(posX, posY + 20), ground)));
        ground.addComponent(new SpriteRenderer(ground, new Sprite(new Image(GlobalAnimations.IMAGE_PATH + GlobalAnimations.GROUND))));
        ground.setActive(true);
        ground.start();
    }

    public Dinosaur getDinosaur() {

        return this.dinosaur;
    }

}
