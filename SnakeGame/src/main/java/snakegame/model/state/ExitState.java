package snakegame.model.state;

import javafx.application.Platform;
import snakegame.model.GameManager;

/**
 * Class representing the game's exit state and its operation
 */
public class ExitState implements State {
    /**
     * Perform the operation of each game state
     * @param gameManager game manager
     */
    @Override
    public void doAction(GameManager gameManager) {
        gameManager.setCurrentState(this);
        Platform.exit();
    }
}
