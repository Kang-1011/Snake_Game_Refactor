package snakegame.model.text;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import snakegame.model.GameManager;

/**
 * Class of the game over text and its operation
 */
public class GameOverText implements Drawable {
    /**
     * Draw game over text
     * @param gc graphic context
     * @param gameManager game manager
     * @param SCREEN_WIDTH screen width
     * @param SCREEN_HEIGHT screen height
     * @param UNIT_SIZE defined size of a single unit
     */
    @Override
    public void draw(GraphicsContext gc, GameManager gameManager, int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE) {
        gc.setFill(Color.RED);
        gc.setFont(Font.font("Ink Free", 75));
        gc.fillText("Game Over lol get rekt", (SCREEN_WIDTH - gc.getFont().getSize() * 10) / 2, SCREEN_HEIGHT / 2);
    }
}
