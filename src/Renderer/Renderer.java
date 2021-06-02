package Renderer;

import ECS.Transform;
import Engine.GameEngine;
import UI.Designer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Renderer {

    public static void render(Image image, Transform transform) {

        Designer.gc.drawImage(image, transform.getPos().x, transform.getPos().y,
                image.getWidth() * transform.getScale().x,image.getHeight() * transform.getScale().y);

    }

    public static void clear() {

        Designer.gc.setFill(Color.WHITE);
        Designer.gc.fillRect(GameEngine.camera.getPos().x,
                GameEngine.camera.getPos().y, Designer.scene.getWidth(), Designer.scene.getHeight());

    }

}
