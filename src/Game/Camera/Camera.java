package Game.Camera;

import Game.GameObjects.GameObject;
import UI.Designer;
import mikera.vectorz.Vector2;

public abstract class Camera {

    private GameObject target;
    private Vector2 pos;
    private Vector2 vel;

    public Camera(GameObject target) {

        this.target = target;
        this.pos = new Vector2();
        this.vel = new Vector2();
    }

    public abstract void followTarget();

    public void changeTarget(GameObject target) {

        this.target = target;
    }

    public void restartCamera(){

        Designer.gc.translate(this.pos.x,0);
    }

    public Vector2 getPos() {

        return this.pos;
    }

    public Vector2 getVel() {

        return this.vel;
    }

    public GameObject getTarget() {

        return this.target;
    }

}
