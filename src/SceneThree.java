import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class SceneThree extends SceneOutline 
{
    public SceneThree(String q, String[] a, String[] r, Stage stage, LevelOutline lvl)
    {
        super(q, a, r, stage, lvl);
    }

    public void setScene() 
    {
        if(level.getPreviousSceneScore() == 0 && currentLevel == 1)
        {
            currentLevel--;
            VBox gameOverPane = new VBox(20);
            gameOverPane.setAlignment(Pos.CENTER);
            Label failReason = new Label("The patient screams in pain. They also contract an infection, so they are transferred to a different hospital.");
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

            // Styling
            gameOverPane.setAlignment(Pos.CENTER);
            BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
            Background back = new Background(backFill);
            gameOverPane.setBackground(back);
            BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
            Background buttonBack = new Background(buttonFill);
            button.setBackground(buttonBack);

            gameOverPane.getChildren().addAll(youLose, gameOver, button); //add stylish text
            resultScreen = new Scene(gameOverPane, 720, 540);
            primaryStage.setScene(resultScreen);
        }
        if(level.getPreviousSceneScore() == 1 && currentLevel == 1)
        {
            currentLevel--;
            VBox gameOverPane = new VBox(20);
            gameOverPane.setAlignment(Pos.CENTER);

            Label failReason = new Label("The patient screams in pain. Luckily they do not contract an infection. " +
            "However, your foolishness forces the patient to be transferred to a different hospital");
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

            // Styling
            gameOverPane.setAlignment(Pos.CENTER);
            BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
            Background back = new Background(backFill);
            gameOverPane.setBackground(back);
            BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
            Background buttonBack = new Background(buttonFill);
            button.setBackground(buttonBack);

            gameOverPane.getChildren().addAll(youLose, gameOver, button); //add stylish text
            resultScreen = new Scene(gameOverPane, 720, 540);
            primaryStage.setScene(resultScreen);
        }
        if (level.getPreviousSceneScore() >= 2)
        {
            score = -1;
            Label task = new Label(question);
            feedback = new Label("");

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
            
            // Styling
            pane1.setAlignment(Pos.CENTER);
            BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
            Background back = new Background(backFill);
            pane1.setBackground(back);
            BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
            Background buttonBack = new Background(buttonFill);
            task.setStyle("-fx-font-size: 15; -fx-font-weight: bold;");
            confirm.setBackground(buttonBack);

            pane1.getChildren().addAll(confirm, feedback);

            sampleScene = new Scene(pane1, 720, 540);
            primaryStage.setScene(sampleScene);
            super.buttonActivation();

            primaryStage.show();
        }

        
    }

    public void setUpNextPage()
    {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
        {
            public void handle(ActionEvent e) 
            {
                level.sceneThreeResultAndSwitch(score); 
            }   
        };
        nxtPage.setOnAction(event);
        pane1.getChildren().add(nxtPage);

        //Button Styling
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        nxtPage.setBackground(buttonBack);
    }
}