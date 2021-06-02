package ECS;

import mikera.vectorz.Vector2;

public class Transform {

    private Vector2 pos;
    private Vector2 scale;

    public Transform(Vector2 pos) {

        this.pos = pos;
        this.scale = new Vector2(1, 1);
    }

    public Vector2 getPos() {

        return this.pos;
    }

    public Vector2 getScale() {

        return this.scale;
    }

    public void setScale(Vector2 scale) {

        this.scale = scale;
    }

}
