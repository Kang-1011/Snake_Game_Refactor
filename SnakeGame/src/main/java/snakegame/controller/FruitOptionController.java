package snakegame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import snakegame.model.GameManager;
import snakegame.Main;

import java.io.IOException;

/**
 * Controller class managing the action in fruit type selection screen
 */
public class FruitOptionController {
    @FXML
    private ToggleGroup fruitGroup;
    String selectedFruit;
    private GameManager gameManager = GameManager.getGameManager();

    /**
     * Redirect to option screen of the game
     * @throws IOException
     */
    public void switchToOption() throws IOException {
        Main.setRoot("Option");
    }

    /**
     * Change fruit type of the game
     */
    public void switchFruit(){
        RadioButton selected = (RadioButton) fruitGroup.getSelectedToggle();
        if(selected != null){
            selectedFruit = selected.getText();
            switch(selectedFruit){
                case "Apple":
                    gameManager.setSelectedFruit("apple");
                    break;
                case "Lime":
                    gameManager.setSelectedFruit("lime");
                    break;
                case "Banana":
                    gameManager.setSelectedFruit("banana");
                    break;
            }
        }
    }

}
