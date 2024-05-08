package snakegame.model.object.food;

/**
 * Concrete banana class extending fruit class
 */
public class Banana extends Fruit {
    /**
     * Default banana constructor
     */
    public Banana(){
        super();
    }

    /**
     * Returns the string representation of the banana's colour
     * @return string representation of the banana's colour
     */
    @Override
    public String display() {
        return "#ffe135";
    }
}
