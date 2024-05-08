package snakegame.model.object.food;

/**
 * Interface defining the method to relocate the instance and return the string representation of the fruit's colour
 */
public interface Displayable {
    /**
     * Relocate the instance to a new random coordinates
     * @param SCREEN_WIDTH screen width
     * @param SCREEN_HEIGHT screen height
     * @param UNIT_SIZE defined size of a single unit
     */
    void randomLocation(int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE);

    /**
     * Returns the string representation of the fruit's colour
     * @return string representation of the fruit's colour
     */
    String display();
}
