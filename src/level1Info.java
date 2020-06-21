import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        Label info = new Label("Hi " + player + "! You are a surgeon at Northwestern Memorial Hospital and have finished your residency.\n" + 
                                "Your first patient has fallen off a bike and requires stitches. Click next to start your first surgery.\n" + 
                                "The quicker you finish the game the better, however, remember to choose the right choices!");
        next = new Button("Next");
        vBox.getChildren().addAll(info, next);
        vBox.setAlignment(Pos.CENTER);
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