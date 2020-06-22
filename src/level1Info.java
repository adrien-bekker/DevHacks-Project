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

public class level1Info extends Screen {
    private Button next;
    private String player;

    public level1Info(Stage stage, String user)
    {
        super(stage);
        player = user;
    }

    public Scene getScene() 
    {
        // Creates vbox and label
        VBox vBox = new VBox();
        Label info = new Label("Hi " + player + "! You are a surgeon at Northwestern Memorial Hospital and have finished your residency. " + 
                                "Your first patient has fallen off a bike and requires stitches. Click next to start your first surgery. " + 
                                "Speed will reward you, with a 3x multiplier <1 min, 2x multiplier <2 min, 1.5x multiplier <3min. \n" + " ");
        info.setStyle("-fx-font-style: italic; -fx-font-size: 18;");
        info.setWrapText(true);
        info.setPadding(new Insets(10));
        next = new Button("Next");
        info.setAlignment(Pos.CENTER);

        ImageView knee = new ImageView(new Image("file:src/Knee.png"));
        knee.setFitHeight(150);
        knee.setFitWidth(300);
        
        vBox.getChildren().addAll(info, knee, next);
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
                new LevelOne(primaryStage);
            } 
        };
        
        next.setOnAction(eventNext);
    }
}