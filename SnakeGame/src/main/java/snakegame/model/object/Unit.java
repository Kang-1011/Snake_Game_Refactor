package snakegame.model.object;

/**
 * Class representing the coordinates of an instance
 */
public class Unit {
    /**
     * X coordinates
     */
    private int x;
    /**
     * Y coordinates
     */
    private int y;

    /**
     * Default constructor
     */
    public Unit(){

    }

    /**
     * Constructor to set the coordinates of the instance to the given parameter 'x' and 'y'
     * @param x x coordinates
     * @param y y coordinates
     */
    public Unit(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Return the x coordinates of the instance
     * @return x coordinates of the instance
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x coordinates of the instance to the given parameter 'x'
     * @param x x coordinates
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Return the y coordinates of the instance
     * @return y coordinates of the instance
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y coordinates of the instance to the given parameter 'y'
     * @param y y coordinates
     */
    public void setY(int y) {
        this.y = y;
    }
}
