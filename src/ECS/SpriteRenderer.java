package ECS;

import Game.GameObjects.GameObject;

import java.util.List;

public class SpriteRenderer extends Component {

    private SpriteSheet spriteSheet;
    private Sprite sprite;

    public SpriteRenderer(GameObject gameObject, SpriteSheet spriteSheet) {
        super(gameObject);

        this.spriteSheet = spriteSheet;
    }

    public SpriteRenderer(GameObject gameObject, Sprite sprite) {
        super(gameObject);

        this.sprite = sprite;
    }

    @Override
    public void update() {

    }

    public SpriteSheet getSpriteSheet() {
        return this.spriteSheet;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public List<Sprite> getSprites() {
        return this.spriteSheet.getSprites();
    }

    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }
}
