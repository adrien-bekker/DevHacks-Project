import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Level3Info extends Screen {
    private Button next;
    private String player;

    public Level3Info(Stage stage)
    {
        super(stage);  
    }

    public Scene getScene() 
    {
        // Creates vbox and label
        VBox vBox = new VBox();
        Label info = new Label("Your patient has shown signs of liver failure including jaundice and swollen ankles. " + 
            "You think that the patient has liver disease and needs a transplant. " + 
            "You will perform the procedure. What will you do?" + " ");
        info.setStyle("-fx-font-style: italic; -fx-font-size: 18;");
        info.setWrapText(true);
        info.setPadding(new Insets(10));
        next = new Button("Next");
        info.setAlignment(Pos.CENTER);

        ImageView liver = new ImageView(new Image("file:src/Liver.png"));
        liver.setFitHeight(150);
        liver.setFitWidth(300);

        vBox.getChildren().addAll(info, liver, next);
        vBox.setAlignment(Pos.CENTER);

        // Creates background and sets button color
        BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
        Background back = new Background(backFill);
        vBox.setBackground(back);
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        next.setBackground(buttonBack);
        buttonActivation();
        Scene scene = new Scene(vBox, 720, 540);

        return scene;
    }

    public void buttonActivation() 
    {
                // When next button is pressed
        EventHandler<ActionEvent> eventNext = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                new LevelThree(primaryStage);
            } 
        };
        
        next.setOnAction(eventNext);
    }
}