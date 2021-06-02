package ECS;

import Game.GameObjects.GameObject;
import UI.Designer;
import mikera.vectorz.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Collider extends Component {

    private Vector2 pos;
    private Vector2 size;
    private Vector2 center;
    private Vector2 halfSize;
    public static List<Collider> colliders = new ArrayList<>();

    public Collider(GameObject gameObject, double sizeX, double sizeY) {
        super(gameObject);

        this.pos = gameObject.getTransform().getPos();
        this.size = new Vector2(sizeX, sizeY);
        this.halfSize = new Vector2(sizeX / 2, sizeY / 2);
        colliders.add(this);
        Designer.gc.strokeRect(this.pos.x,this.pos.y,sizeX,sizeY);

    }

    public Collider(GameObject gameObject, double sizeX, double sizeY, Transform transform) {

        this(gameObject, sizeX, sizeY);
        this.pos = transform.getPos();
    }

    @Override
    public void update() {

        for (int i = 0; i < colliders.size(); i++) {

            Collider collider = colliders.get(i);

            if (collider == this) {

                continue;
            }

            if (this.checkCollision(collider)) {

                this.getGameObject().onCollisionEnter(collider.getGameObject());
            }

        }

    }

    private boolean checkCollision(Collider collider) {

        this.calculateCenter();
        collider.calculateCenter();

        double dx = this.center.x - collider.getCenter().x;
        double dy = this.center.y - collider.getCenter().y;

        double combinedHalfWidths = this.halfSize.x + collider.getHalfSize().x;
        double combinedHalfHeights = this.halfSize.y + collider.getHalfSize().y;

        if (Math.abs(dx) <= combinedHalfWidths && Math.abs(dy) <= combinedHalfHeights) {

            int overLapX = (int) (combinedHalfWidths - Math.abs(dx));
            int overLapY = (int) (combinedHalfHeights - Math.abs(dy));

            if (overLapX == overLapY && overLapX == 0) return false;

            return true;
        }

        return false;

    }

    private void calculateCenter() {

        this.center = new Vector2(this.pos.x + this.halfSize.x, this.pos.y + this.halfSize.y);
    }

    public Vector2 getCenter() {

        return this.center;
    }

    public Vector2 getHalfSize() {

        return this.halfSize;
    }

    public Vector2 getSize() {

        return this.size;
    }

    public Vector2 getPos() {

        return this.pos;
    }

    public void resize(double sizeX, double sizeY) {

        this.halfSize = new Vector2(sizeX / 2, sizeY / 2);
        this.size.x = sizeX;
        this.size.y = sizeY;

    }

}
