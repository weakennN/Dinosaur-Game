package Game.Camera;

import ECS.Rigidbody;
import Game.GameObjects.GameObject;
import Game.Validator.Validator;
import UI.Designer;

public class GameCamera extends Camera {

    public GameCamera(GameObject target) {

        super(target);
    }

    @Override
    public void followTarget() {

        Rigidbody rigidbody = (Rigidbody) super.getTarget().getComponent(Rigidbody.class);

        if (!Validator.isNull(rigidbody) && super.getTarget().isActive()) {

            super.getPos().x += rigidbody.getVel().x;
            Designer.gc.translate(-rigidbody.getVel().x, 0);

        }

    }

}
