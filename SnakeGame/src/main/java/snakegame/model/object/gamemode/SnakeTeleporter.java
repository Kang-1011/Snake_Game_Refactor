package snakegame.model.object.gamemode;

import snakegame.model.GameManager;

/**
 * Class representing the game mode 'Snake Teleporter' and its operation
 */
public class SnakeTeleporter implements Level {
    /**
     * Operation in game mode 'Snake Teleporter'
     * @param gameManager game manager
     */
    @Override
    public void executeLevelFeatures(GameManager gameManager) {
        gameManager.getSnake().teleport(gameManager.getScreenHeight() , gameManager.getScreenWidth(), gameManager.getUnitSize());
    }
}
