package snakegame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import snakegame.model.GameManager;
import snakegame.Main;

import java.io.IOException;

/**
 * Controller class managing the action in background colour selection screen
 */
public class ColorOptionController {
    @FXML
    private ToggleGroup colorGroup;
    @FXML
    private AnchorPane colorPane;
    String selectedColor;
    private GameManager gameManager = GameManager.getGameManager();

    /**
     * Redirect to option screen of the game
     * @throws IOException
     */
    public void switchToOption() throws IOException {
        Main.setRoot("Option");
    }

    /**
     * Change background colour of the game
     */
    public void changeColor(){
        RadioButton selected = (RadioButton) colorGroup.getSelectedToggle();

        if(selected != null){
            selectedColor = selected.getText();

            switch(selectedColor){
                case "Cyan":
                    colorPane.setStyle("-fx-background-color: cyan;");
                    gameManager.setSelectedColor("cyan");
                    break;
                case "Orange":
                    colorPane.setStyle("-fx-background-color: orange;");
                    gameManager.setSelectedColor("orange");
                    break;
                case "Yellow":
                    colorPane.setStyle("-fx-background-color: yellow;");
                    gameManager.setSelectedColor("yellow");
                    break;
                case "Olive":
                    colorPane.setStyle("-fx-background-color: olive;");
                    gameManager.setSelectedColor("olive");
                    break;
                case "Salmon":
                    colorPane.setStyle("-fx-background-color: salmon;");
                    gameManager.setSelectedColor("salmon");
                    break;
                case "Pink":
                    colorPane.setStyle("-fx-background-color: pink;");
                    gameManager.setSelectedColor("pink");
                    break;
                case "Plum":
                    colorPane.setStyle("-fx-background-color: plum;");
                    gameManager.setSelectedColor("plum");
                    break;
                case "Brown":
                    colorPane.setStyle("-fx-background-color: brown;");
                    gameManager.setSelectedColor("brown");
                    break;
                default:
                    colorPane.setStyle("-fx-background-color: black;");
                    gameManager.setSelectedColor("black");
            }
        }
    }
}
