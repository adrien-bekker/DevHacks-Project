import java.util.ArrayList;

import javafx.stage.Stage;

public abstract class LevelOutline 
{
    protected ArrayList<Integer> scores;
    protected int currentScene;
    protected Stage primaryStage;

    public LevelOutline(Stage stage)
    {
        primaryStage = stage;
        scores = new ArrayList<Integer>();
        playSceneOne();
        currentScene = 0;
    }

    public abstract void playSceneOne();

    public abstract void playSceneTwo();

    public abstract void playSceneThree();

    public abstract void sceneOneResultAndSwitch(int score);

    public abstract void sceneTwoResultAndSwitch(int score);

    public abstract void sceneThreeResultAndSwitch(int score);

    public int getPreviousSceneScore()
    {
        return scores.get(currentScene - 1);
    }
}