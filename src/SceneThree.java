import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.*;


public class SceneThree extends SceneOutline 
{
    public SceneThree(String q, String[] a, String[] r, Stage stage, LevelOutline lvl)
    {
        super(q, a, r, stage, lvl);
    }

    //sets up the scene that will be displayed to the user
    public void setScene() 
    {
        if(level.getPreviousSceneScore() == 0 && currentLevel == 1)
        {
            l1Failure0pts();
        }
        else if(level.getPreviousSceneScore() == 1 && currentLevel == 1)
        {
            l1Failure1pt();
        }
        else if(level.getPreviousSceneScore() == 0 && currentLevel == 2)
        {
            l2Failure0pts();
        }
        else if(level.getPreviousSceneScore() == 1 && currentLevel == 2)
        {
            l2Failure1pt();
        }
        else if(level.getPreviousSceneScore() == 0 && currentLevel == 3) //level 3 0 points
        {
            l3Failure0pts();
        }
        else if(level.getPreviousSceneScore() == 1 && currentLevel == 3) //level 3 1 point
        {
            l3Failure1pt();
        }
        if (level.getPreviousSceneScore() >= 2)
        {
            setUpScene();
        }  
    }

    //this method is called when the user failed on level 1 with the 0 pt option
    public void l1Failure0pts()
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

    //this method is called when the user failed on level 1 with the 1 pt option
    public void l1Failure1pt()
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

    //this method is called when the user failed on level 2 with the 0 pt option
    public void l2Failure0pts()
    {
        currentLevel--;
        VBox gameOverPane = new VBox(20);
        gameOverPane.setAlignment(Pos.CENTER);

        Label failReason = new Label("Many necessary steps were skipped before removing the appendix, resulting in a severe infection for the patient");
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

    //this method is called when the user failed on level 2 with the 1 pt option
    public void l2Failure1pt()
    {
        currentLevel--;
        VBox gameOverPane = new VBox(20);
        gameOverPane.setAlignment(Pos.CENTER);

        Label failReason = new Label("The patient still suffers from appendicitis and also has a laparoscope in their chest.");
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

    //this method is called when the user failed on level 3 with the 0 pt option
    public void l3Failure0pts()
    {
        currentLevel--;
        VBox gameOverPane = new VBox(20);
        gameOverPane.setAlignment(Pos.CENTER);

        Label failReason = new Label("The patient suffers from extreme blood loss. Their family is suing our hospital now.");
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

    //this method is called when the user failed on level 3 with the 1 pt option
    public void l3Failure1pt()
    {
        currentLevel--;
        VBox gameOverPane = new VBox(20);
        gameOverPane.setAlignment(Pos.CENTER);

        Label failReason = new Label("The patient loses a lot of blood but you are able to salvage it. Unfortunately your \"method\" was not very efficient.");
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

    //sets up the scene if the user chose a correct option
    public void setUpScene()
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
        VBox pane2 = new VBox(10);
        pane1.getChildren().addAll(task);
        int chosen = 0;

        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for(int i = 1; i <= 4; i++)
            randoms.add(i);

        while(randoms.size() > 0)
        {
            chosen = randoms.remove((int) (Math.random()*(randoms.size())));
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
        super.buttonActivation();

        primaryStage.show();
    }

    //sets up the nextpagebutton
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