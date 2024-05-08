package snakegame.model.object.food;

/**
 * Concrete lime class extending fruit class
 */
public class Lime extends Fruit {
    /**
     * Default lime constructor
     */
    public Lime() {
        super();
    }

    /**
     * Returns the string representation of the lime's colour
     * @return string representation of the lime's colour
     */
    @Override
    public String display() {
        return "lime";
    }
}
