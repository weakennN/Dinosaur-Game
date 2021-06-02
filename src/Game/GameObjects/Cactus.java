package Game.GameObjects;

public class Cactus extends GameObject {

    public Cactus(String tag, String animation) {
        super(tag);

        super.setCurrentAnimation(animation);
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

        super.updateComponents();
    }

    @Override
    public void onCollisionEnter(GameObject other) {


    }

}
