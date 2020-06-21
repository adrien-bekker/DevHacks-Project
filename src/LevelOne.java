import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelOne {
    private ArrayList<Integer> scores;
    private int currentScene;
    private Stage primaryStage;

    public LevelOne(Stage stage) {
        primaryStage = stage;
        scores = new ArrayList<Integer>();
        playSceneOne();
        currentScene = 0;
    }

    public void playSceneOne() {
        // Questions and answers
        String question = "What materials do you need?";
        String[] answers = { "Needle, needle holder, sutures, local nerve block, disinfectant",
                "Needle, needle holder, sutures, heavy sedative",
                "Needle, needle holder, sutures, scalpel, rubbing alcohol, vaseline", "Bare hands" };
        String[] responses = { "Nurse recommends anesthetic so you grab that as well " };

        // Creates Scene 1 and sets it on the primary Stage
        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage);
        primaryStage.setScene(s1.getScene());
    
        
        // Gets the score of the action NEED HALP
        int value = s1.getScore();
        System.out.println(value);

    }

    public void playSceneTwo() {

    }

    public void playSceneThree() {

    }
}