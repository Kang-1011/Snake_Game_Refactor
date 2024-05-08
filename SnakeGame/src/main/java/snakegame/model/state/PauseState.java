package snakegame.model.state;

import javafx.animation.Timeline;
import snakegame.model.GameManager;

/**
 * Class representing the game's pause state and its operation
 */
public class PauseState implements State {
    /**
     * Game keyframe animation timeline
     */
    Timeline timeline;

    /**
     * Constructor with parameter 'timeline' to initialise the class field 'timeline'
     * @param timeline game keyframe animation timeline
     */
    public PauseState(Timeline timeline){
        this.timeline = timeline;
    }

    /**
     * Perform the operation of each game state
     * @param gameManager game manager
     */
    @Override
    public void doAction(GameManager gameManager) {
        gameManager.setCurrentState(this);
        timeline.pause();
    }
}
