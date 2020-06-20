import java.util.ArrayList;

import javafx.stage.Stage;

public class LevelOne extends Screen
{
    private ArrayList<Integer> scores;
    private int currentScene;
    public LevelOne(Stage stage)
    {
        super(stage);

        scores = new ArrayList<Integer>();
        playSceneOne();
        currentScene = 0;
    }

    public void playSceneOne()
    {
        String question = "What materials do you need?";
        String[] answers = {"Needle, needle holder, sutures, local nerve block, disinfectant", 
        "Needle, needle holder, sutures, heavy sedative", "Needle, needle holder, sutures, scalpel, rubbing alcohol, vaseline",
        "Bare hands"};
        String[] responses = {"Nurse recommends anesthetic so you grab that as well "}; 

        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage);
        
        scores.add(s1.start());
        System.out.println(scores.get(0) + "");

    }

    public ArrayList<Integer> getScores()
    {
        return
    }
    public void playSceneTwo()
    {

    }

    public void playSceneThree()
    {

    }
}