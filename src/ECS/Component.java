package ECS;

import Game.GameObjects.GameObject;

public abstract class Component {

    private GameObject gameObject;

    public Component(GameObject gameObject) {

        this.gameObject = gameObject;
    }

    public abstract void update();

    public GameObject getGameObject() {

        return this.gameObject;
    }

}
