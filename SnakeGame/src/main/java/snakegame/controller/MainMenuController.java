package snakegame.controller;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import snakegame.model.state.ExitState;
import snakegame.Main;


import java.io.IOException;
import java.nio.file.Paths;
import static snakegame.model.GameManager.getGameManager;

/**
 * Controller class managing the action in main menu
 */
public class MainMenuController {
    private Stage stage;
    @FXML
    private MediaView mediaView;
    @FXML
    private AnchorPane scenePane;

    /**
     * Play background music
     * @throws IOException
     */
    @FXML
    public void initialize() {
        String s = "src/main/resources/snakegame/Sin Chan Piano BGM.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(()->{
            mediaPlayer.stop();
        });

        mediaView = new MediaView(mediaPlayer);
        scenePane.getChildren().add(mediaView);
    }

    /**
     * Redirect to option screen of the game
     * @throws IOException
     */
    public void switchToOption() throws IOException{
        Main.setRoot("Option");
    }

    /**
     * Redirect to info screen of the game
     * @throws IOException
     */
    public void switchtoInfo() throws IOException{
        Main.setRoot("Instruction");
    }

    /**
     * Redirect to game screen
     * @throws IOException
     */
    public void switchtoGame() throws IOException{
        Main.setRoot("GameScene");
    }

    /**
     * Exit program
     * @throws IOException
     */
    public void exitGame() throws IOException{
        ExitState exitState = new ExitState();
        exitState.doAction(getGameManager());
    }
}
