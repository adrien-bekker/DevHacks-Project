import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class LevelOutline
{
    protected static ArrayList<Integer> scores;
    protected int currentScene;
    protected Stage primaryStage;

    public LevelOutline(Stage stage)
    {
        primaryStage = stage;
        playSceneOne();
        scores = new ArrayList<Integer>();
        currentScene = 0;
    }

    //for accessing sum alone
    public LevelOutline(Stage stage, int num)
    {
        primaryStage = stage;
        currentScene = 0;
    }

    public abstract void playSceneOne();

    public abstract void playSceneTwo();

    public abstract void playSceneThree();

    public void sceneOneResultAndSwitch(int score)
    {
        scores.add(score);
        currentScene++;
        playSceneTwo();
    }

    public void sceneTwoResultAndSwitch(int score)
    {
        scores.add(score);
        currentScene++;
        playSceneThree();
    }

    public void sceneThreeResultAndSwitch(int score)
    {
        scores.add(score);
        currentScene++;
        getConclusionScreen();
    }

    public int getPreviousSceneScore()
    {
        return scores.get(currentScene - 1);
    }

    public abstract void getConclusionScreen();

    public int getSum()
    {
        int sum = 0;
        for(int i = 0; i < scores.size(); i++)
        {
            sum += scores.get(i);
        }
        return sum;
    }
    
}