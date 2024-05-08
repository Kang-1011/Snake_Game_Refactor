package snakegame.model.text;

import javafx.scene.canvas.GraphicsContext;
import snakegame.model.GameManager;

/**
 * Interface defining a method to draw
 */
public interface Drawable {
    /**
     * Draw text
     * @param gc graphic context
     * @param gameManager game manager
     * @param SCREEN_WIDTH screen width
     * @param SCREEN_HEIGHT screen height
     * @param UNIT_SIZE defined size of a single unit
     */
    void draw(GraphicsContext gc, GameManager gameManager, int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE);
}
