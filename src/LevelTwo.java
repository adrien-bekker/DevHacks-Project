import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LevelTwo extends LevelOutline
{

    public LevelTwo(Stage stage) 
    {
        super(stage);
    }

    public void playSceneOne() {
        // Questions and answers
        System.out.println(scores);
        /*String question = "What materials do you need?";
        String[] answers = { "Trocar , laparoscope, clamp, staples",
                "Trocar, laparoscope, clamp, scalpel",
                    "Scalpel, laparoscope, sutures, staples", "Hammer" };
        String[] responses = { "Nurse recommends a trocar so you find that" };

            // Creates Scene 2 and sets it on the primary Stage
        SceneOne s1 = new SceneOne(question, answers, responses, primaryStage, this);
        s1.setScene();*/
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
        String[] answers = { "Loop the suture around the needle holder, grasp the suture end with needle holder, pull the needle holder towards you and lay the final knot",
                "Loop the suture around the needle holder, grasp the suture end with needle holder, pull the needle holder towards you and lay the final knot, trim the suture ends",
                    "Loop the suture around the needle holder, grasp the suture end with needle holder, trim the suture ends", 
                    "Tie single knot like tying a shoelace over the wound" };
        String[] responses = {""};

        // Creates Scene 3 and sets it on the primary Stage
        SceneThree s3 = new SceneThree(question, answers, responses, primaryStage, this);
        s3.setScene();
    }

    public void getConclusionScreen()
    {
        VBox elements = new VBox(10);
        Label congrats = new Label("Congratulations surgeon. You have suceeded in your first surgery.");

        congrats.setWrapText(true);
        congrats.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 15));
        congrats.setTextFill(Color.GREEN);
        int sum = 0;
        for(int i = 0; i < scores.size(); i++)
        {
            sum += scores.get(i);
        }

        Label points = new Label("You earned " + sum + " points.");
        points.setWrapText(true);
        points.setFont(Font.font("Comic Sans", FontWeight.BOLD, 15));
        points.setTextFill(Color.BLUE);

        elements.getChildren().addAll(congrats, points);
        Pane l1EndPane = new Pane(elements);
        Scene l1EndScene = new Scene(l1EndPane, 720, 540);
        primaryStage.setScene(l1EndScene);
    }
}