import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
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
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SceneOne extends SceneOutline {
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

        //Button Styling
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        nxtPage.setBackground(buttonBack);

        pane1.getChildren().add(nxtPage);
    }
}