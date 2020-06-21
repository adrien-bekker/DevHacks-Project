import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SceneOne extends SceneOutline
{
    private static int currentLevel;
    public SceneOne(String q, String[] a, String[] r, Stage stage, LevelOutline lvl) 
    {
        super(q, a, r, stage, lvl);
        currentLevel++;
    }

    public void setScene() 
    {
        score = -1;
        Label task = new Label(question);
        feedback = new Label(" ");

        configureB1();
        configureB2();
        configureB3();
        configureB4();
        confirm = new Button("Confirm");
        
        pane1 = new VBox(20);
        pane1.getChildren().addAll(task);
        int chosen = 0;

        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for(int i = 1; i <= 4; i++)
            randoms.add(i);

        int randIndex = 0;
        while(randoms.size() > 0)
        {
            randIndex = (int) (Math.random()*randoms.size());
            chosen = randoms.remove(randIndex);
            if(chosen == 1)
                pane1.getChildren().add(button1);
            else if(chosen == 2)
                pane1.getChildren().add(button2);
            else if(chosen == 3)
                pane1.getChildren().add(button3);
            else if(chosen == 4)
                pane1.getChildren().add(button4);
        }
        
        pane1.getChildren().addAll(confirm, feedback);
        sampleScene = new Scene(pane1, 720, 540);
        primaryStage.setScene(sampleScene);
        buttonActivation();

        primaryStage.show();
    }

    public void setUpNextPage()
    {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                level.sceneOneResultAndSwitch(score);
                
            }   
        };
        nxtPage.setOnAction(event);

        pane1.getChildren().add(nxtPage);
    }

    public void setLevel(int newLevel)
    {
        currentLevel = newLevel;
    }
}