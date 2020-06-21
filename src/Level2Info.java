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
import javafx.stage.Stage;

public class Level2Info extends Screen {
    private Button next;
    private String player;

    public Level2Info(Stage stage)
    {
        super(stage);
    }

    public Scene getScene() 
    {
        // Creates vbox and label
        VBox vBox = new VBox();
        Label info = new Label("This patient is a little tougher. " + 
            "He has appendicitis; a condition in which the appendix becomes inflamed and filled with pus, causing pain." + 
            "To remove it you will have to perform an appendectomy." + 
            "Good luck! \n" + " ");
        info.setStyle("-fx-font-style: italic; -fx-font-size: 18;");
        info.setWrapText(true);
        info.setPadding(new Insets(10));
        next = new Button("Next");
        info.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(info, next);
        vBox.setAlignment(Pos.CENTER);

        // Creates background and sets button color
        BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
        Background back = new Background(backFill);
        vBox.setBackground(back);
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        next.setBackground(buttonBack);

        Scene scene = new Scene(vBox, 720, 540);

        return scene;
    }

    public void buttonActivation() 
    {
                // When next button is pressed
        EventHandler<ActionEvent> eventNext = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                new LevelTwo(primaryStage);
            } 
        };
        
        next.setOnAction(eventNext);
    }
}