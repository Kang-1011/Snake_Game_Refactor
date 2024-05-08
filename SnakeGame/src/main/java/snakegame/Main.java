package snakegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class to start the application
 */
public class Main extends Application {
    private static Scene scene;

    public void start(Stage stage) throws Exception{
        scene = new Scene(loadFXML("MainMenu"));
        stage.resizableProperty().setValue(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Set root of scene with the given parameter 'fxml'
     * @param fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Load fxml
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

