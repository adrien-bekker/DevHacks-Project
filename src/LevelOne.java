import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LevelOne {
    private ArrayList<Integer> scores;
    private int currentScene;
    protected Stage primaryStage;

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
        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage, this);
        s1.setScene();
    

    }

    public void sceneOneResultAndSwitch(int score) 
    {
        scores.add(score);
        System.out.println(score);
        playSceneTwo();
    }

    public void playSceneTwo() 
    {
        /*if(scores.get(0) == 1)
        {
            try 
            {
                TimeUnit.SECONDS.sleep(2);
            } 
            catch (InterruptedException e1) 
            {
                ;
            }
        }
        /*
        String question = "What materials do you need?";
        String[] answers = { "Needle, needle holder, sutures, local nerve block, disinfectant",
                "Needle, needle holder, sutures, heavy sedative",
                "Needle, needle holder, sutures, scalpel, rubbing alcohol, vaseline", "Bare hands" };
        String[] responses = { "Nurse recommends anesthetic so you grab that as well " };

        // Creates Scene 1 and sets it on the primary Stage
        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage, this);
        s1.setScene();*/
    }

    public void playSceneThree() 
    {

    }
}