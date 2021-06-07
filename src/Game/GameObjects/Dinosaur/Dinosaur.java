package Game.GameObjects.Dinosaur;

import ECS.Animator;
import ECS.Rigidbody;
import ECS.SpriteRenderer;
import ECS.Transform;
import Game.Animator.GlobalAnimations;
import Game.Common.GlobalVariables;
import Game.GameObjects.GameObject;

public class Dinosaur extends GameObject {

    private DinosaurManager manager;

    private boolean isDead;
    private boolean jumping;
    private boolean idle;
    private boolean running;
    private boolean crouching;

    public Dinosaur(String tag) {

        super(tag);

        this.isDead = false;
        this.jumping = false;
        this.idle = true;
        this.running = false;
        super.setActive(true);
        //    super.setCurrentAnimation(GlobalAnimations.DinosaurIdle);
        DinosaurState.running = true;
        this.manager = new DinosaurManager(this);
    }

    @Override
    public void start() {

        super.start();
        this.idle = false;
        this.running = false;
        this.getRigidbody().getVel().x = 2.5;
      //  super.getComponent(Animator.class).setAnimation(2, 3);

    }

    @Override
    public void update() {

        super.updateComponents();
    }

    @Override
    public void onCollisionEnter(GameObject other) {

        if (other.getTag().equals(GlobalVariables.CACTUS_TAG) || other.getTag().equals(GlobalVariables.BAT_TAG)) {

            this.manager.killDinosaur();
        }

    }

    public void jump() {

        // super.setCurrentAnimation(GlobalAnimations.DinosaurIdle);
        //super.getComponent(Animator.class).setAnimation(0, 0);
        super.getComponent(Animator.class).getAnimationController().playAnimation("idleAndJumping");
        this.getRigidbody().getVel().y = -2.5;
        this.jumping = true;
        this.running = false;
        DinosaurState.running = false;
    }

    public Rigidbody getRigidbody() {

        return super.getComponent(Rigidbody.class);
    }

    public boolean isDead() {

        return this.isDead;
    }

    public boolean isJumping() {

        return this.jumping;
    }

    public void setJumping(boolean jumping) {

        this.jumping = jumping;
    }

    public boolean isIdle() {

        return this.idle;
    }

    public void setIdle(boolean b) {

        this.idle = b;
    }

    public void setRunning(boolean b) {

        this.running = b;
    }

    public void setDead(boolean b) {

        this.isDead = b;
    }

    public DinosaurManager getManager() {

        return this.manager;
    }

    public void setCrouching(boolean b) {

        this.crouching = b;
    }

    public boolean isCrouching() {

        return this.crouching;
    }

    public boolean isRunning() {

        return this.running;
    }

}
