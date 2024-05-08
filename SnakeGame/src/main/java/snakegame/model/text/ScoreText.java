package snakegame.model.text;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import snakegame.model.GameManager;

/**
 * Class of the score text and its operation
 */
public class ScoreText implements Drawable {
    /**
     * Draw score text
     * @param gc graphic context
     * @param gameManager game manager
     * @param SCREEN_WIDTH screen width
     * @param SCREEN_HEIGHT screen height
     * @param UNIT_SIZE defined size of a single unit
     */
    @Override
    public void draw(GraphicsContext gc, GameManager gameManager, int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE) {
        gc.setFill(Color.RED);
        gc.setFont(Font.font("Ink Free", FontWeight.BOLD, 40));
        gc.fillText("Score: " + gameManager.getScore(), (SCREEN_WIDTH - gc.getFont().getSize() * 5) / 2, gc.getFont().getSize());
    }
}
