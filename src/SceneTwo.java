
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SceneTwo extends SceneOutline 
{
    public SceneTwo(String q, String[] a, String[] r, Stage stage, LevelOutline lvl)
    {
        super(q, a, r, stage, lvl);
    }

    //sets up scene two to display for the user
    public void setScene() 
    {
        if(level.getPreviousSceneScore() == 0) //if the player chose the "dumb" option
        {
            VBox gameOverPane = new VBox(20);
            gameOverPane.setAlignment(Pos.CENTER);
            Label failReason = new Label("The patient gives you a puzzling look and refuses to have surgery" + 
            " as they believe it is unsafe. They decide to go to a different hospital.");
            failReason.setWrapText(true);
            gameOverPane.getChildren().add(failReason);
    
            Label youLose = new Label("Your medical license has been revoked.");
            youLose.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 15));

            Label gameOver = new Label("Game Over");
            gameOver.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 25));
            gameOver.setTextFill(Color.RED);

            Button button = new Button("Restart Level");
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent e) 
                {
                    new LevelOne(primaryStage);
                    
                }
            };
            button.setOnAction(event);

            gameOverPane.getChildren().addAll(youLose, gameOver, button); //add stylish text
            resultScreen = new Scene(gameOverPane, 720, 540);
            primaryStage.setScene(resultScreen);
        }
        else //if the player chose a logical option
        {
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
    }

    public void setUpNextPage()
    {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                level.sceneTwoResultAndSwitch(score);
                
            }   
        };
        nxtPage.setOnAction(event);

        pane1.getChildren().add(nxtPage);
    }
}