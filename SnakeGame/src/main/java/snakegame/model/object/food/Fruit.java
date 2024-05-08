package snakegame.model.object.food;

import snakegame.model.object.Unit;

import java.util.Random;

/**
 * Abstract fruit class
 */
public abstract class Fruit extends Unit implements Displayable {
    /**
     * Default constructor
     */
    public Fruit() {
    }

    /**
     * Relocate the instance to a new random coordinates
     * @param SCREEN_WIDTH screen width
     * @param SCREEN_HEIGHT screen height
     * @param UNIT_SIZE defined size of a single unit
     */
    @Override
    public void randomLocation(int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE) {
        Random random = new Random();

        setX((random.nextInt(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE);
        setY((random.nextInt(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE);
    }

    /**
     * Returns the string representation of the fruit's colour
     * @return string representation of the fruit's colour
     */
    public abstract String display();
}
