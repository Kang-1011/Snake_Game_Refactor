package snakegame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import snakegame.Main;

import java.io.IOException;

/**
 * Controller class managing the action in info screen
 */
public class InfoController {
    /**
     * Redirect to main menu of the game
     * @throws IOException
     */
    public void switchToMainMenu() throws IOException {
        Main.setRoot("MainMenu");
    }
}
