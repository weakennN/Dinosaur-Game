package Renderer;

import ECS.SpriteRenderer;
import ECS.Transform;
import Engine.GameEngine;
import Game.GameObjects.GameObject;
import UI.Designer;
import javafx.scene.paint.Color;

public class Renderer {

    public static void render(GameObject gameObject) {

        SpriteRenderer spriteRenderer = gameObject.getComponent(SpriteRenderer.class);
        Transform transform = gameObject.getTransform();

        Designer.gc.drawImage(spriteRenderer.getSprite().getTexture(), transform.getPos().x, transform.getPos().y,
                spriteRenderer.getSprite().getTexture().getWidth() * transform.getScale().x,
                spriteRenderer.getSprite().getTexture().getHeight() * transform.getScale().y);
    }

    public static void clear() {

        Designer.gc.setFill(Color.WHITE);

        Designer.gc.fillRect(GameEngine.camera.getPos().x,
                GameEngine.camera.getPos().y, Designer.scene.getWidth(), Designer.scene.getHeight());

    }

}
