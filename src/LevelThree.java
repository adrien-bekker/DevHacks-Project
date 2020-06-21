import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class LevelThree extends LevelOutline {
    public LevelThree(Stage stage)
    {
        super(stage);
    }

    public void playSceneOne() {
        // Questions and answers
        String question = "What materials do you need?";
        String[] answers = { "Scalpel, retractors, suction tube, clamps",
                "Scalpel, retractors, suction tube, trocar",
                    "Scalpel, retractors, trocar, gas pump tube", "Machete"};
        String[] responses = { "Nurse recommends a suction tube so you find it" };

            // Creates Scene 2 and sets it on the primary Stage
        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage, this);
        s1.setScene();
    }

    public void playSceneTwo() 
    {
        String question = "What order do you perform the procedure?";
        String[] answers = { "Make initial incision, detach liver attachments, isolate important parts of the liver, remove diseased liver",
                "Make initial incision, detach liver attachments, cut and clamp veins and arteries, remove diseased liver",
                    "Make initial incision, detach liver attachments, remove diseased liver", "Slice the abdomen open with machete and carve out the liver" };
        String[] responses = {""};

        // Creates Scene 1 and sets it on the primary Stage
        SceneTwo s2 = new SceneTwo(question, answers, responses, primaryStage, this);
        s2.setScene();
        
    }

    public void playSceneThree() 
    {
        String question = "What order will you perform the last steps?";
        String[] answers = { "Place in new liver, reattach new veins and arteries, ensure adequate control of bleeding, suture patient up and provide immunosuppressive drugs",
                "Place in new liver, reattach new veins and arteries, suture patient up and provide immunosuppressive drugs",
                    "Place in new liver, reattach new veins and arteries, suture patient up", 
                    "Put the new liver in the abdomen and suture the patient up" };
        String[] responses = {""};

        // Creates Scene 3 and sets it on the primary Stage
        SceneThree s3 = new SceneThree(question, answers, responses, primaryStage, this);
        s3.setScene();
    }

    public void getConclusionScreen()
    {
        // Success or failure text
        System.out.println(scores);
        VBox elements = new VBox(10);

        int sum = 0;
        for(int i = 0; i < scores.size(); i++)
        {
            sum += scores.get(i);
        }
        
        Label congrats = new Label("");
        Button button = new Button("");

        if (sum > 5)
        {
            if(sum == 9)
                congrats.setText("Well done surgeon. You have now proven yourself to be the best surgeon of Northwestern Memorial Hospital.");
            else
                congrats.setText("Well done surgeon. You have now proven yourself to be a adequate surgeon of Northwestern Memorial Hospital.");
            button.setText("End Game");
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent e) 
                {
                    System.exit(0);
                }   
            };
            button.setOnAction(event);
        }
        else
        {
            congrats.setText("Sorry, you have failed your surgery. Please restart the level.");
            button.setText("Restart Level");
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent e) 
                {
                    new LevelOne(primaryStage);
                    
                }
            };
            button.setOnAction(event);
        }   

        // Congratulations text
        congrats.setWrapText(true);
        congrats.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 15));
        if(sum > 5)
            congrats.setTextFill(Color.GREEN);
        else
            congrats.setTextFill(Color.RED);

        Label points = new Label("You earned " + sum + " points.");
        points.setWrapText(true);
        points.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
        points.setTextFill(Color.BLUE);


        // Styling
        elements.setAlignment(Pos.CENTER);
        BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
        Background back = new Background(backFill);
        elements.setBackground(back);
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        button.setBackground(buttonBack);

        // Adding elements
        elements.getChildren().addAll(congrats, points, button);
        Scene l1EndScene = new Scene(elements, 720, 540);
        primaryStage.setScene(l1EndScene);
    }
}