package snakegame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import snakegame.Main;
import snakegame.model.GameManager;
import snakegame.model.object.gamemode.LizardObstacle;
import snakegame.model.object.gamemode.SnakeTeleporter;
import snakegame.model.object.gamemode.SpeedIncrease;

import java.io.IOException;

/**
 * Controller class managing the action in game mode selection screen
 */
public class GameModeController {
    @FXML
    private ToggleGroup gameModes;
    private String selectedGameMode;
    private GameManager gameManager = GameManager.getGameManager();

    /**
     * Redirect to option screen of the game
     * @throws IOException
     */
    public void switchToOption() throws IOException {
        Main.setRoot("Option");
    }

    /**
     * Change game mode
     */
    public void switchGameMode(){
        RadioButton selected = (RadioButton) gameModes.getSelectedToggle();
        if(selected != null){
            selectedGameMode = selected.getText();
            switch(selectedGameMode){
                case "Speed Increase":
                    gameManager.setGameMode(new SpeedIncrease());
                    break;
                case "Snake Teleporter":
                    gameManager.setGameMode(new SnakeTeleporter());
                    break;
                case "Lizard Obstacle":
                    gameManager.setGameMode(new LizardObstacle());
                    break;
                default:
                    gameManager.setGameMode(null);
                    break;
            }
        }
    }
}
