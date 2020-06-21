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

public class SceneOne extends Screen {
    private String question;
    private String[] answers, responses;
    private ToggleGroup group;
    private RadioButton button1, button2, button3, button4;
    private Button confirm, nxtPage;
    private int score = -1, scene1Pos = 0;
    private Scene sampleScene;
    private Label feedback;
    private LevelOne level;
    private VBox pane1;
    public SceneOne(String q, String[] a, String[] r, Stage stage, LevelOne lvl) {
        super(stage);
        question = q;
        answers = a;
        responses = r;
        group = new ToggleGroup();
        level = lvl;
    }

    public void setScene() {
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

        while(randoms.size() > 0)
        {
            chosen = randoms.remove((int) (Math.random()*(randoms.size())));
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

        System.out.println(group.getSelectedToggle());
        primaryStage.show();
    }

    private void configureB1() {
        button1 = new RadioButton(answers[0]);
        button1.setToggleGroup(group);
    }

    private void configureB2() {
        button2 = new RadioButton(answers[1]);
        button2.setToggleGroup(group);
    }

    private void configureB3() {
        button3 = new RadioButton(answers[2]);
        button3.setToggleGroup(group);
    }

    private void configureB4() {
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

    @Override
    public Scene getScene() {
        // TODO Auto-generated method stub
        return null;
    }

}