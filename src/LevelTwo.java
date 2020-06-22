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


public class LevelTwo extends LevelOutline 
{
    private static int levelSum;
    public LevelTwo(Stage stage)
    {
        super(stage);
        
    }

    public LevelTwo(Stage stage, int num) 
    {
        super(stage, num);
    }

    public void playSceneOne() {
        // Questions and answers
        String question = "What materials do you need?";
        String[] answers = { "Trocar, laparoscope, clamp, staples",
                "Trocar, laparoscope, clamp, scalpel",
                    "Scalpel, laparoscope, sutures, staples", "Hammer" };
        String[] responses = { "Nurse recommends a trocar so you find that" };

            // Creates Scene 2 and sets it on the primary Stage
        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage, this);
        s1.setScene();
    }

    public void playSceneTwo() 
    {
        String question = "What order do you perform the procedure?";
        String[] answers = { "Make a small key hole, pump gas into abdomen, place in laparoscope, clamp and remove appendix",
                "Make a small key hole, place in laparoscope, clamp and remove appendix",
                    "Place in laparoscope, clamp and remove appendix", "Remove appendix" };
        String[] responses = {""};

        // Creates Scene 1 and sets it on the primary Stage
        SceneTwo s2 = new SceneTwo(question, answers, responses, primaryStage, this);
        s2.setScene();
        
    }

    public void playSceneThree() 
    {
        String question = "What order will you perform the last steps?";
        String[] answers = { "Remove the trocars from the abdomen, remove the laparoscope, allow the gas to flow out of the abdomen, then suture up the incisions",
                "Remove the laparoscope, remove the trocars from the abdomen, allow the gas to flow out of the abdomen, then suture up the incisions",
                    "Remove the trocars from the abdomen, allow the gas to flow out of the abdomen", 
                    "Suture up the incisions leaving instruments in patient" };
        String[] responses = {""};

        // Creates Scene 3 and sets it on the primary Stage
        SceneThree s3 = new SceneThree(question, answers, responses, primaryStage, this);
        s3.setScene();
    }

    public void getConclusionScreen()
    {
        // Success or failure text
        VBox elements = new VBox(10);

        levelSum = getSum();
        int sum = getSum();
        
        Label congrats = new Label("");
        Button button = new Button("");

        if (sum > 5)
        {
            congrats.setText("Nice work surgeon. We're glad to have you on our team. You earned " + sum + " points.");
            button.setText("Next Level");
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent e) 
                {
                    Level3Info info = new Level3Info(primaryStage);
                    primaryStage.setScene(info.getScene());
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

    public int getLevelSum()
    {
        return levelSum;
    }
}