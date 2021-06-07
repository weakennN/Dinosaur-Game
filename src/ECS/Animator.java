package ECS;

import Game.GameObjects.GameObject;

public class Animator extends Component {

    private AnimationController animationController;

    public Animator(GameObject gameObject) {
        super(gameObject);
    }

    public Animator(GameObject gameObject, AnimationController animationController) {
        super(gameObject);

        this.animationController = animationController;
    }

    @Override
    public void update() {

    }

    public void setAnimationController(AnimationController animationController) {
        this.animationController = animationController;
    }

    public AnimationController getAnimationController() {
        return this.animationController;
    }
}
