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

public class SceneOne extends Screen
{
    private String question;
    private String[] answers, responses;
    private ToggleGroup group;
    private RadioButton button1, button2, button3, button4;
    private Button confirm;
    private int score = -1, scene1Pos = 0;
    private Scene sampleScene;
    private Stage primaryStage;
    private Label feedback;
    boolean stop = false;

    public SceneOne(String q, String[] a, String[] r, Stage stage)
    {
        super(stage);
        question = q;
        answers = a;
        responses = r;
        group = new ToggleGroup();
    }

    public Scene getScene()
    {
        score = -1;
        Label task = new Label(question);
        feedback  = new Label();

        configureB1();
        configureB2();
        configureB3();
        configureB4();
        confirm = new Button("Confirm");

        VBox pane1 = new VBox(5);
        pane1.getChildren().addAll(task, button1, button2, button3, button4, confirm, feedback);
        sampleScene = new Scene(pane1);
        buttonActivation();
        return sampleScene;
    }

    private void configureB1()
    {
        button1 = new RadioButton(answers[0]);
        button1.setToggleGroup(group);
    }

    private void configureB2()
    {
        button2 = new RadioButton(answers[1]);
        button2.setToggleGroup(group);
    }

    private void configureB3()
    {
        button3 = new RadioButton(answers[2]);
        button3.setToggleGroup(group);
    }

    private void configureB4()
    {
        button4 = new RadioButton(answers[3]);
        button4.setToggleGroup(group);
    }

    public void buttonActivation()
    {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                if(group.getSelectedToggle().isSelected())
                {
                    if(group.getSelectedToggle().equals(button1))
                    {
                        score = 3;
                        
                    }
                    else if(group.getSelectedToggle().equals(button2))
                    {
                        score = 2;
                    }
                    else if(group.getSelectedToggle().equals(button3))
                    {
                        score = 1;
                    }
                    else if(group.getSelectedToggle().equals(button4))
                    {
                        score = 0;
                    }
                }
                
            } 
        }
    }

    public int getScore()
    {
        return score;
    }

    public void waiter()
    {
        
    }

}