package snakegame.model;

import javafx.scene.canvas.GraphicsContext;
import snakegame.Direction;
import snakegame.controller.SnakeGameController;
import snakegame.model.object.Snake;
import snakegame.model.object.Unit;
import snakegame.model.object.gamemode.DefaultMode;
import snakegame.model.object.gamemode.Level;
import snakegame.model.state.State;
import snakegame.model.text.Drawable;
import snakegame.model.text.GameOverText;
import snakegame.model.object.food.Fruit;
import snakegame.model.object.food.FruitFactory;
import snakegame.model.text.ScoreText;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

/**
 * Class coordinating the game mechanism between different objects in the game
 */
public class GameManager {
    /**
     * Screen width
     */
    private static final int SCREEN_WIDTH = 1300;
    /**
     * Screen height
     */
    private static final int SCREEN_HEIGHT = 750;
    /**
     * Size of a single unit
     */
    private static final int UNIT_SIZE = 50;
    static int DELAY = 170;
    private static GameManager gameManager;
    private SnakeGameController snakeGameController;
    /**
     * Stores the background colour preference
     */
    private static final Preferences preferences = Preferences.userNodeForPackage(GameManager.class);
    private static final String SELECTED_COLOR_KEY = "selectedColor";
    private static String selectedColor;
    private int score = 0;
    private static String selectedFruitText = "apple";
    private boolean running = false;
    private FruitFactory fruitFactory;
    private Fruit fruit;
    private Snake snake;
    private Drawable scoreText;
    private Drawable gameOverText;
    private List<Unit> obstacles;
    private State currentState;
    private Level gameMode;

    private GameManager() {
        this.snake = new Snake(new Unit(0, 0), Direction.Right);
        initFruit();
        this.obstacles = new ArrayList<>();

        this.scoreText = new ScoreText();
        this.gameOverText = new GameOverText();
        this.gameMode = new DefaultMode();

    }

    /**
     * Initialise the fruit factory, create a fruit instance of the selected type and relocate the fruit instance
     */
    private void initFruit() {
        this.fruitFactory = new FruitFactory();
        this.fruit = fruitFactory.createFruit(getSelectedFruitText());
        this.fruit.randomLocation(SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
    }

    public static GameManager getGameManager() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public SnakeGameController getSnakeGameController() {
        return snakeGameController;
    }

    public void setSnakeGameController(SnakeGameController snakeGameController) {
        this.snakeGameController = snakeGameController;
    }

    public static int getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public static int getUnitSize() {
        return UNIT_SIZE;
    }

    public static int getDELAY() {
        return DELAY;
    }

    public void setDELAY(int delay) {
        DELAY = delay;
    }

    public static String getSelectedColor(){
        return preferences.get(SELECTED_COLOR_KEY, selectedColor);
    }

    public static void setSelectedColor(String color){
        preferences.put(SELECTED_COLOR_KEY,color);
    }

    public int getScore(){
        return score;
    }

    public static String getSelectedFruitText() {
        return selectedFruitText;
    }

    public void setSelectedFruit(String fruit){
        selectedFruitText = fruit;
        this.fruit = fruitFactory.createFruit(getSelectedFruitText());
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Snake getSnake() {
        return snake;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setDirection(Direction direction) {
        this.snake.setDirection(direction);
    }

    public List<Unit> getObstacles() {
        return obstacles;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Level getGameMode() {
        return gameMode;
    }

    /**
     * Set game mode to the parameter 'gameMode'
     * @param gameMode
     */
    public void setGameMode(Level gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * Increase the size of the snake and current game score by 1 , relocate the fruit and execute the function according
     * to the selected game mode if the first unit of the snake has the same coordinates with the fruit
     */
    public void checkFruit() {
        if ((snake.getHead().getX() == getFruit().getX()) && (snake.getHead().getY() == getFruit().getY())) {
            snake.grow();
            score++;
            fruit.randomLocation(SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
            getGameMode().executeLevelFeatures(this);
        }
    }

    /**
     * Relocate the fruit position if its coordinates is the same with any obstacle from the list of obstacles
     */
    public void checkFruitOnObstacle() {
        for (int j = 0; j < obstacles.size(); j++) {
            if ((getFruit().getX() == obstacles.get(j).getX()) && (getFruit().getY() == obstacles.get(j).getY())) {
                fruit.randomLocation(SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
            }
        }
    }

    /**
     * Adds a number of new obstacles into the list of obstacles, with their coordinates identical to the number of
     * unit of snake counting from back
     */
    public void lizardObstacle() {
        int i = getSnake().getBody().size();
        for (int j = 1; j <= i / 2; j++) {
            this.obstacles.add(new Unit((snake.getBody().get(i - j).getX()), (snake.getBody().get(i - j).getY())));
        }
    }

    /**
     * Remove the fourth element from the list of obstacles if the total amount of obstacles is more than 3
     */
    public void removeObstacle() {
        if (getObstacles().size() > 3) {
            this.obstacles.remove(3);
        }
    }

    /**
     * Set game's field 'running' to false if the first unit of snake collides with obstacles, its body or screen
     * border, which stops the game; true otherwise, which continues the game
     */
    public void checkCollisions() {
        setRunning(getSnake().detectCollisions(getObstacles(), SCREEN_HEIGHT, SCREEN_WIDTH));
    }

    /**
     * Draw score text
     * @param gc graphic context
     */
    public void drawScoreText(GraphicsContext gc) {
        scoreText.draw(gc, this, SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
    }

    /**
     * Draw game over text
     * @param gc graphic context
     */
    public void drawGameOverText(GraphicsContext gc) {
        gameOverText.draw(gc, this, SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
    }
}
