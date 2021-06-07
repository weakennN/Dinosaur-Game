package Game.GameObjects;

import ECS.Animator;
import ECS.Collider;
import ECS.Component;
import ECS.Transform;
import Game.DinosaurGame;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    private List<Component> components;
    private String tag;
    private boolean active;

    public GameObject(String tag) {

        this.tag = tag;
        this.components = new ArrayList<>();
        DinosaurGame.gameObjects.add(this);
    }

    public void start() {

        for (int i = 0; i < this.components.size(); i++) {

            Component component = this.components.get(i);

            if (!component.isActive()) {

                component.setActive(true);
            }
        }
    }

    public abstract void update();

    public abstract void onCollisionEnter(GameObject other);

    public void addComponent(Component component) {

        this.components.add(component);
    }

    public <T extends Component> T getComponent(Class<T> component) {

        for (Component c : components) {

            if (component.isAssignableFrom(c.getClass())) {

                return component.cast(c);
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

        Collider.colliders.remove(this.getComponent(Collider.class));
        DinosaurGame.gameObjects.remove(this);

        if (this.getComponent(Animator.class) != null){
            this.getComponent(Animator.class).getAnimationController().stop();
        }

        this.components.clear();
    }

    public String getTag() {
        return tag;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean b) {

        this.active = b;
    }

    public Transform getTransform() {

        return this.getComponent(Transform.class);
    }
}
