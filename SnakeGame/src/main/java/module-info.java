module com.example.snakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires javafx.media;


    exports snakegame;
    opens snakegame to javafx.fxml;
    exports snakegame.controller;
    opens snakegame.controller to javafx.fxml;
    exports snakegame.model;
    opens snakegame.model to javafx.fxml;
    exports snakegame.model.object.food;
    opens snakegame.model.object.food to javafx.fxml;
    exports snakegame.model.text;
    opens snakegame.model.text to javafx.fxml;
    exports snakegame.model.state;
    opens snakegame.model.state to javafx.fxml;
    exports snakegame.model.object;
    opens snakegame.model.object to javafx.fxml;
    exports snakegame.model.object.gamemode;
    opens snakegame.model.object.gamemode to javafx.fxml;
}