package snakegame.model.state;

import snakegame.model.GameManager;

/**
 * Interface defining the operation in each game state
 */
public interface State {
    /**
     * Perform the operation of each game state
     * @param gameManager game manager
     */
    void doAction(GameManager gameManager);

}
