import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class LevelOutline extends Screen
{
    protected static ArrayList<Integer> scores;
    protected int currentScene;
    protected Stage primaryStage;

    public LevelOutline(Stage stage)
    {
        super(stage);
        scores = new ArrayList<Integer>();
        playSceneOne();
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

    public void buttonActivation() {}

    public Scene getScene() {
        return null;
    }
    
}