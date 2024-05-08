package snakegame.model.object.gamemode;

import snakegame.model.GameManager;

/**
 * Class representing the game mode 'Speed Increase' and its operation
 */
public class SpeedIncrease implements Level {
    /**
     * Operation in game mode 'Speed Increase'
     * @param gameManager game manager
     */
    @Override
    public void executeLevelFeatures(GameManager gameManager) {
        gameManager.setDELAY(GameManager.getDELAY() - 5);
        gameManager.getSnakeGameController().updateSpeed();
    }
}
