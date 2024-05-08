package snakegame.model.object.gamemode;

import snakegame.model.GameManager;

/**
 * Class representing the game mode 'Lizard Obstacle' and its operation
 */
public class LizardObstacle implements Level {
    /**
     * Operation in game mode 'Lizard Obstacle'
     * @param gameManager game manager
     */
    @Override
    public void executeLevelFeatures(GameManager gameManager) {
        gameManager.lizardObstacle();
        gameManager.removeObstacle();
        gameManager.checkFruitOnObstacle();
    }
}
