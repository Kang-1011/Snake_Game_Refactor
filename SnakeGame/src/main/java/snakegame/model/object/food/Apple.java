package snakegame.model.object.food;

/**
 * Concrete apple class extending fruit class
 */
public class Apple extends Fruit {
    /**
     * Default apple constructor
     */
    public Apple() {
        super();
    }

    /**
     * Returns the string representation of the apple's colour
     * @return string representation of the apple's colour
     */
    @Override
    public String display() {
        return "red";
    }
}
