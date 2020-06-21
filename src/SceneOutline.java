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

public abstract class SceneOutline extends Screen
{
    protected Scene resultScreen;
    protected String question;
    protected String[] answers, responses;
    protected ToggleGroup group;
    protected RadioButton button1, button2, button3, button4;
    protected Button confirm, nxtPage;
    protected int score = -1, scene1Pos = 0;
    protected Scene sampleScene;
    protected Label feedback;
    protected LevelOutline level;
    protected VBox pane1;

    public SceneOutline(String q, String[] a, String[] r, Stage stage, LevelOutline lvl) {
        super(stage);
        question = q;
        answers = a;
        responses = r;
        group = new ToggleGroup();
        level = lvl;
    }

    protected abstract void setScene();

    protected void configureB1() {
        button1 = new RadioButton(answers[0]);
        button1.setToggleGroup(group);
    }

    protected void configureB2() {
        button2 = new RadioButton(answers[1]);
        button2.setToggleGroup(group);
    }

    protected void configureB3() {
        button3 = new RadioButton(answers[2]);
        button3.setToggleGroup(group);
    }

    protected void configureB4() {
        button4 = new RadioButton(answers[3]);
        button4.setToggleGroup(group);
    }

    public void buttonActivation() {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                if (group.getSelectedToggle().isSelected()) 
                {
                    if (group.getSelectedToggle().equals(button1)) 
                    {
                        score = 3;

                    } 
                    else if (group.getSelectedToggle().equals(button2)) 
                    {
                        score = 2;
                    } 
                    else if (group.getSelectedToggle().equals(button3)) 
                    {
                        score = 1;
                        feedback.setText(responses[0]);
                        
                    }
                    else if(group.getSelectedToggle().equals(button4))
                    {
                        score = 0;
                    }

                    button1.setDisable(true);
                    button2.setDisable(true);
                    button3.setDisable(true);
                    button4.setDisable(true);
                    confirm.setDisable(true);
                    
                    nxtPage = new Button("Next Page");
                    setUpNextPage();

                }
                
            } 
            
        };
        confirm.setOnAction(event);
    }

    public int getScore()
    {
        return score;
    }

    public abstract void setUpNextPage();

    @Override
    public Scene getScene() {
        // TODO Auto-generated method stub
        return null;
    }  
}