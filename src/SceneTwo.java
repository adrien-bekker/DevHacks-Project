import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
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
        if(level.getPreviousSceneScore() == 0 && currentLevel == 1) //if the player chose the "dumb" option
        {
            l1Failure();
        }
        else if(level.getPreviousSceneScore() == 0 && currentLevel == 2)
        {
            l2Failure();
        }
        else if(level.getPreviousSceneScore() == 0 && currentLevel == 3)
        {
            l3Failure();
        }
        else //if the player chose a logical option
        {
            setUpScene();
        }
    }

    //this method will activate when the user chooses a wrong answer in the first scene in level 1
    public void l1Failure()
    {
        currentLevel--;
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
                System.out.println();
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

    //this method will activate when the user chooses a wrong answer in the first scene in level 2
    public void l2Failure()
    {
        currentLevel--;
        VBox gameOverPane = new VBox(20);
        gameOverPane.setAlignment(Pos.CENTER);
        Label failReason = new Label("Why would you use a hammer in a surgery?");
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
                System.out.println();
                new LevelTwo(primaryStage);
                
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

    //this method will activate when the user chooses a wrong answer in the first scene in level 3
    public void l3Failure()
    {
        currentLevel--;
        VBox gameOverPane = new VBox(20);
        gameOverPane.setAlignment(Pos.CENTER);
        Label failReason = new Label("The patient hemorrhages severely and dies on the operating table. Good job. (sarcasm)");
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
                System.out.println();
                new LevelThree(primaryStage);
                
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

    //this method sets up the scene of Scene2 given the user does not select a wrong answer
    public void setUpScene()
    {
        Label task = new Label(question);
        feedback = new Label(" ");

        configureB1();
        configureB2();
        configureB3();
        configureB4();
        confirm = new Button("Confirm");
        
        pane1 = new VBox(20);
        VBox pane2 = new VBox(10);
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
                pane2.getChildren().add(button1);
            else if(chosen == 2)
                pane2.getChildren().add(button2);
            else if(chosen == 3)
                pane2.getChildren().add(button3);
            else if(chosen == 4)
                pane2.getChildren().add(button4);
        }
        
        // Styling
        pane2.setAlignment(Pos.CENTER_LEFT);
        pane1.getChildren().add(pane2);
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
        buttonActivation();

        primaryStage.show();
    }

    //this method is used to set up the button "nxtPage" so that the user can progress
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
        //Button Styling
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        nxtPage.setBackground(buttonBack);

        pane1.getChildren().add(nxtPage);
    }
}