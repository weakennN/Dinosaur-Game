package Game.GameObjects;

import ECS.Collider;
import ECS.Component;
import ECS.Transform;
import Game.Animator.GlobalAnimations;
import Game.DinosaurGame;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    private List<Component> components;
    private Transform transform;
    private String tag;
    private boolean active;
    private Image currentAnimation;

    public GameObject(String tag, Transform transform) {

        this.tag = tag;
        this.transform = transform;
        this.components = new ArrayList<>();
        DinosaurGame.gameObjects.add(this);
        this.active = true;
    }

    public abstract void start();

    public abstract void update();

    public abstract void onCollisionEnter(GameObject other);

    public void addComponent(Component component) {

        this.components.add(component);
    }

    public <T extends Component> Component getComponent(Class<T> component) {

        for (Component c : components) {

            if (component.isAssignableFrom(c.getClass())) {

                return c;
            }

        }

        return null;
    }

    public <T extends Component> void removeComponent(Class<T> component) {

        components.removeIf(c -> component.isAssignableFrom(c.getClass()));

    }

    protected void updateComponents() {

        for (int i = 0; i < this.components.size(); i++) {

            Component c = this.components.get(i);

            c.update();
        }

    }

    public void destroy() {

        Collider.colliders.remove((Collider) this.getComponent(Collider.class));
        DinosaurGame.gameObjects.remove(this);
        this.components.clear();
    }

    public Image render() {

        return this.currentAnimation;
    }

    public Transform getTransform() {
        return transform;
    }

    public String getTag() {
        return tag;
    }

    public boolean isActive() {
        return active;
    }

    public void setCurrentAnimation(String animation) {

        this.currentAnimation = new Image(GlobalAnimations.IMAGE_PATH + animation);
    }

    public void setActive(boolean b) {

        this.active = b;
    }

    public Image getCurrentAnimation(){

        return this.currentAnimation;
    }

}
