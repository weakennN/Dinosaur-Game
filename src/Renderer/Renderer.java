package Renderer;

import ECS.SprtieRenderer.SortingLayer;
import ECS.SprtieRenderer.SortingLayersContainer;
import ECS.SprtieRenderer.SpriteRenderer;
import ECS.Transform;
import Engine.GameEngine;
import Game.GameObjects.GameObject;
import UI.Designer;
import javafx.scene.paint.Color;

public class Renderer {

    public void render(GameObject gameObject) {

        SpriteRenderer spriteRenderer = gameObject.getComponent(SpriteRenderer.class);
        Transform transform = gameObject.getTransform();

        if (spriteRenderer.getSprite() == null){

            System.out.println();
        }

        Designer.gc.drawImage(spriteRenderer.getSprite().getTexture(), transform.getPos().x, transform.getPos().y,
                spriteRenderer.getSprite().getTexture().getWidth() * transform.getScale().x,
                spriteRenderer.getSprite().getTexture().getHeight() * transform.getScale().y);
    }

    public void clear() {

        Designer.gc.setFill(Color.WHITE);

        Designer.gc.fillRect(GameEngine.camera.getPos().x,
                GameEngine.camera.getPos().y, Designer.scene.getWidth(), Designer.scene.getHeight());

    }

    public void render() {

        for (int i = 0; i < SortingLayersContainer.sortingLayers.size(); i++) {

            SortingLayer sortingLayer = SortingLayersContainer.sortingLayers.get(i);

            for (int j = 0; j < sortingLayer.getSpriteRenderers().size(); j++) {

                GameObject gameObject = sortingLayer.getSpriteRenderers().get(j).getGameObject();

                render(gameObject);
            }

        }
    }
}
