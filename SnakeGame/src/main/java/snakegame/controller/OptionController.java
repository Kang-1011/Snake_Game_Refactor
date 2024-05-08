package snakegame.controller;

import snakegame.Main;

import java.io.IOException;

/**
 * Controller class managing the action in option screen
 */
public class OptionController {
    /**
     * Redirect to background colour selection screen of the game
     * @throws IOException
     */
    public void switchToSelectColor() throws IOException {
        Main.setRoot("colorOption");
    }

    /**
     * Redirect to fruit type selection screen of the game
     * @throws IOException
     */
    public void switchToSelectFruit() throws IOException{
        Main.setRoot("fruitOption");
    }

    /**
     * Redirect to game mode selection screen of the game
     * @throws IOException
     */
    public void switchToSelectGameMode() throws IOException {
        Main.setRoot("GameMode");
    }

    /**
     * Redirect to main menu of the game
     * @throws IOException
     */
    public void switchToMainMenu() throws IOException {
        Main.setRoot("MainMenu");
    }
}
