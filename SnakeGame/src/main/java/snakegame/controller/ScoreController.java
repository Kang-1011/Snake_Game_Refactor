package snakegame.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import snakegame.model.state.ExitState;
import snakegame.model.GameManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Controller class managing the action in score screen (scoreboard)
 */
public class ScoreController {
    private GameManager gameManager = GameManager.getGameManager();
    @FXML
    private Label scoresLabel;
    @FXML
    private VBox scoreListContainer;
    @FXML
    private Label scoreList;

    /**
     * File storing the list of scores
     */
    private final String SCORE_FILE_PATH = "scores.txt";

    /**
     * Set the score label of the scoreboard to be the final score of the current game
     */
    public void setScoresLabel() {
        scoresLabel.setText("Your score: " + gameManager.getScore());
        updateScore(gameManager.getScore());
    }

    /**
     * Update the scores in the file
     */
    public void updateScore(int newScore){
        List<Integer> scores = getTopScores();
        scores.add(newScore);
        Collections.sort(scores,Collections.reverseOrder());
        List<Integer> topScores = scores.subList(0,Math.min(scores.size(),10));
        writeScores(topScores);
    }

    /**
     * Show the top scores
     */
    public void showTopScoresPopup() {
        createScoreFile();
        List<Integer> topScores = getTopScores();

        for(Integer score : topScores){
            Label scoreLabel = new Label(String.valueOf(score));
            scoreLabel.setFont(Font.font("Bell MT",16));
            scoreListContainer.setAlignment(Pos.CENTER);
            scoreListContainer.getChildren().add(scoreLabel);
        }
    }

    /**
     * Create the file "scores.txt" if not existed
     */
    private void createScoreFile(){
        File file = new File(SCORE_FILE_PATH);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Read the scores from the file
     * @return the list of scores initially stored in the file
     */
    private List<Integer> getTopScores() {
        List<Integer> scores = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("scores.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                if(!line.isEmpty()){
                    try{
                        int score = Integer.parseInt(line.trim());
                        scores.add(score);
                    } catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException | NumberFormatException e){
            e.printStackTrace();
        }

        Collections.sort(scores, Collections.reverseOrder());

        return scores.subList(0,Math.min(scores.size(),10));
    }

    /**
     * Update the file with new list of scores
     * @param scores the new list of scores
     */
    private void writeScores(List<Integer> scores){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE_PATH))){
            for(Integer score : scores){
                writer.write(score + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Exit program
     */
    public void exitGame(){
        ExitState exitState = new ExitState();
        exitState.doAction(gameManager);
    }
}
