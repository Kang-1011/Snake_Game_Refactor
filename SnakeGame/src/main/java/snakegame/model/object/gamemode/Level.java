package snakegame.model.object.gamemode;

import snakegame.model.GameManager;

/**
 * Interface defining a method to perform selected game mode operation
 */
public interface Level {
    /**
     * Perform the selected game mode operation
     * @param gameManager game manager
     */
    void executeLevelFeatures(GameManager gameManager);
}
