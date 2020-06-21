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


public class SceneThree extends SceneOutline {

    public SceneThree(String q, String[] a, String[] r, Stage stage, LevelOne lvl)
    {
        super(q, a, r, stage, lvl);
    }

    public void setScene() {
        if (level.getPreviousSceneScore() >= 2)
        {
            score = -1;
            Label task = new Label(question);
            feedback = new Label(" ");

            super.configureB1();
            super.configureB2();
            super.configureB3();
            super.configureB4();
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
        }
        else if (level.getPreviousSceneScore() == 1)
        {
            Label message1 = new Label(responses[1]);
            pane1.getChildren().add(message1);
        }
        else if (level.getPreviousSceneScore() == 0)
        {
            Label message = new Label(responses[0]);
            pane1.getChildren().add(message);
        }
        sampleScene = new Scene(pane1, 720, 540);
        primaryStage.setScene(sampleScene);
        super.buttonActivation();

        System.out.println(group.getSelectedToggle());
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
}