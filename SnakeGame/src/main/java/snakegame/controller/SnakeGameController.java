package snakegame.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import snakegame.Direction;
import snakegame.model.GameManager;
import snakegame.model.state.ExitState;
import snakegame.model.state.PauseState;
import snakegame.model.state.ResumeState;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class managing the in-game controls
 */
public class SnakeGameController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private Canvas gameCanvas;
    Direction direction = Direction.Right;
    Timeline timeline;
    GraphicsContext graphicContext;
    private boolean scoreboardShown = false;
    private GameManager gameManager;

    /**
     * Initialize the following when this is first loaded
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicContext = gameCanvas.getGraphicsContext2D();
        gameCanvas.setFocusTraversable(true);

        setGameControls(gameCanvas);

        gameCanvas.requestFocus();
        startGame(graphicContext);
    }

    /**
     * Set game controls
     * @param gameCanvas
     */
    public void setGameControls(Canvas gameCanvas) {
        gameCanvas.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    if (direction != Direction.Down) {
                        direction = Direction.Up;
                        gameManager.setDirection(direction);
                    }
                    break;
                case DOWN:
                    if (direction != Direction.Up) {
                        direction = Direction.Down;
                        gameManager.setDirection(direction);
                    }
                    break;
                case LEFT:
                    if (direction != Direction.Right) {
                        direction = Direction.Left;
                        gameManager.setDirection(direction);
                    }
                    break;
                case RIGHT:
                    if (direction != Direction.Left) {
                        direction = Direction.Right;
                        gameManager.setDirection(direction);
                    }
                    break;
                case SPACE:
                    pauseGame();
            }
        });
    }

    public void startGame(GraphicsContext graphicContext) {
        gameManager = GameManager.getGameManager();
        gameManager.setRunning(true);
        gameManager.setSnakeGameController(this);
        timeline = new Timeline(new KeyFrame(Duration.millis(gameManager.getDELAY()), e -> draw(graphicContext)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Update the time offset of the keyframe with a new keyframe
     */
    public void updateSpeed() {
        timeline.stop();
        timeline.getKeyFrames().clear();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(gameManager.getDELAY()), e -> draw(graphicContext));
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    /**
     * Pause the game
     */
    public void pauseGame() {
        PauseState pauseState = new PauseState(timeline);
        pauseState.doAction(gameManager);
    }

    /**
     * Resume gameplay
     */
    public void resumeGame() {
        ResumeState resumeState = new ResumeState(timeline);
        resumeState.doAction(gameManager);
        setGameControls(gameCanvas);
        gameCanvas.requestFocus();
    }

    /**
     * Exit program
     */
    public void exitGame(){
        ExitState exitState = new ExitState();
        exitState.doAction(gameManager);
    }

    /**
     * Draw background, fruit, snake body, obstacles, scores
     * Move the snake, and check if collide with fruit or obstacles
     * @param gc graphic context
     */
    public void draw(GraphicsContext gc) {
        if (gameManager.isRunning()) {
            // Use colour previously set to draw background
            gc.setFill(Color.BLACK);
            if(gameManager.getSelectedColor()!=null) {
                String color = gameManager.getSelectedColor();
                gc.setFill(Color.valueOf(color));
            }
            gc.fillRect(0, 0, gameManager.getScreenWidth(), gameManager.getScreenHeight());

            // Draw fruit
            String colorFruit = gameManager.getFruit().display();
            gc.setFill(Color.valueOf(colorFruit));
            gc.fillOval(gameManager.getFruit().getX(), gameManager.getFruit().getY(), gameManager.getUnitSize(), gameManager.getUnitSize());

            // Draw snake body
            for (int i = 0; i < gameManager.getSnake().getBody().size(); i++) {
                if (i == 0) {
                    gc.setFill(Color.GREEN);
                } else {
                    gc.setFill(Color.rgb(45, 180, 0));
                }
                gc.fillRect(gameManager.getSnake().getBody().get(i).getX(), gameManager.getSnake().getBody().get(i).getY(), gameManager.getUnitSize(), gameManager.getUnitSize());
            }

            // Draw obstacle
            for (int i = 0; i < gameManager.getObstacles().size(); i++) {
                gc.setFill(Color.BEIGE);
                gc.fillRect(gameManager.getObstacles().get(i).getX(), gameManager.getObstacles().get(i).getY(), gameManager.getUnitSize(), gameManager.getUnitSize());
            }

            // Draw score
            gameManager.drawScoreText(gc);

            // Move snake
            gameManager.getSnake().move(gameManager.getUnitSize());

            // Check if fruit is eaten
            gameManager.checkFruit();
        } else {
            gameOver(gc);
            return;
        }
        gameManager.checkCollisions();
    }

    /**
     * Display the game over screen
     * @param gc graphic context
     */
    public void gameOver(GraphicsContext gc) {
        // Score
        gameManager.drawScoreText(gc);

        // Game Over text
        gameManager.drawGameOverText(gc);

        if(!scoreboardShown) {
            showScoreboard();
            scoreboardShown = true;
        }
    }

    /**
     * Display the pop-up screen consisting of the scoreboard
     */
    public void showScoreboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Score.fxml"));
            Parent root = loader.load();

            stage = new Stage();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Scoreboard");
            ScoreController sceneController = loader.getController();
            sceneController.setScoresLabel();
            sceneController.showTopScoresPopup();
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

