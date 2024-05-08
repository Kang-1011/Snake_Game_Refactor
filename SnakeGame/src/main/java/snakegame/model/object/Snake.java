package snakegame.model.object;

import snakegame.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing the game's snake and its operation
 */
public class Snake {
    /**
     * List of units which made up the snake body
     */
    private List<Unit> body = new ArrayList<>();
    /**
     * Snake's moving direction (right by default)
     */
    private Direction direction = Direction.Right;

    /**
     * Constructor to initialise the snake body and its direction
     * @param head
     * @param direction
     */
    public Snake(Unit head, Direction direction) {
        this.init(head);
        this.direction = direction;
    }

    /**
     * Create the snake body with the given parameter 'head'
     * @param head the first unit of the snake
     */
    private void init(Unit head) {
        this.body.add(head);

        while (this.body.size() < 4) {
            this.body.add(new Unit(this.body.getLast().getX(), this.body.getLast().getY()));
        }
    }

    /**
     * Return a list of units which made up the snake body
     * @return list of units which made up the snake body
     */
    public List<Unit> getBody() {
        return this.body;
    }

    /**
     * Return the moving direction of the snake
     * @return moving direction of the snake
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Set the moving direction of the snake to the given parameter 'direction'
     * @param direction moving direction of the snake
     */

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Return the first unit of the snake
     * @return the first unit of the snake
     */
    public Unit getHead() {
        return getBody().get(0);
    }

    /**
     * Update the coordinates of each unit of the snake body according to the moving direction
     * @param UNIT_SIZE defined size of a single unit
     */
    public void move(int UNIT_SIZE) {
        for (int i = body.size() - 1; i > 0; i--) {
            getBody().get(i).setX(getBody().get(i - 1).getX());
            getBody().get(i).setY(getBody().get(i - 1).getY());
        }

        switch (this.direction) {
            case Up:
                getHead().setY(getHead().getY() - UNIT_SIZE);
                break;
            case Down:
                getHead().setY(getHead().getY() + UNIT_SIZE);
                break;
            case Left:
                getHead().setX(getHead().getX() - UNIT_SIZE);
                break;
            case Right:
                getHead().setX(getHead().getX() + UNIT_SIZE);
                break;
        }
    }

    /**
     * Add a unit to the back of the snake body with the coordinates of the previous last unit of the snake
     */
    public void grow() {
        this.body.add(new Unit(getBody().getLast().getX(), getBody().getLast().getY()));
    }

    /**
     * Return false if the first unit of the snake has the same coordinates with any of its body unit, any
     * obstacle, or if it crosses the border
     * @param obstacles list of all obstacles
     * @param SCREEN_HEIGHT screen height
     * @param SCREEN_WIDTH screen width
     * @return false if the first unit of the snake has the same coordinates with any of its body unit, any
     * obstacle, or if it crosses the border
     */
    public boolean detectCollisions(List<Unit> obstacles, int SCREEN_HEIGHT, int SCREEN_WIDTH) {
        // Checks if head collides with body
        for (int i = getBody().size() - 1; i > 0; i--) {
            if ((getBody().get(0).getX() == getBody().get(i).getX()) && (getBody().get(0).getY() == getBody().get(i).getY())) {
                return false;
            }
        }
        // Checks if head collides with obstacles
        for (int j = 0; j < obstacles.size(); j++) {
            if ((getBody().get(0).getX() == obstacles.get(j).getX()) && (getBody().get(0).getY() == obstacles.get(j).getY())) {
                return false;
            }
        }

        // Checks if head touches left border
        if (getBody().get(0).getX() < 0) {
            return false;
        }
        // Checks if head touches right border
        if (getBody().get(0).getX() > SCREEN_WIDTH) {
            return false;
        }
        // Checks if head touches top border
        if (getBody().get(0).getY() < 0) {
            return false;
        }
        // Checks if head touches bottom border
        if (getBody().get(0).getY() > SCREEN_HEIGHT) {
            return false;
        }
        return true;
    }

    /**
     * Relocate the first unit of the snake to a random new coordinates.
     * If the new coordinates is within the distance of (3 * UNIT_SIZE) from any border, relocate again.
     * If the new coordinates is within the distance of (2 * UNIT_SIZE) from any of its body's unit coordinate,
     * relocate again.
     * @param SCREEN_HEIGHT screen height
     * @param SCREEN_WIDTH screen width
     * @param UNIT_SIZE defined size of a single unit
     */
    public void teleport(int SCREEN_HEIGHT, int SCREEN_WIDTH, int UNIT_SIZE) {
        Random random = new Random();

        label:
        do {
            int tempX = (random.nextInt(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            int tempY = (random.nextInt(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

            if ((tempX < (3 * UNIT_SIZE)) || (tempY < (3 * UNIT_SIZE)) || (tempX > (SCREEN_WIDTH - 3 * UNIT_SIZE)) || (tempY > (SCREEN_HEIGHT - 3 * UNIT_SIZE))){
                continue;
            }

            for (int i = 0; i < getBody().size(); i++) {
                if ((Math.abs(getBody().get(i).getX() - tempX) < 2 * UNIT_SIZE) || (Math.abs(getBody().get(i).getY() - tempY) < 2 * UNIT_SIZE))
                    continue label;
            }
            getHead().setX(tempX);
            getHead().setY(tempY);
            break;
        } while (true);
    }
}
