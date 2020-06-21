import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Screen
{
    private Button start;
    private Button exit;

    public MainMenu(Stage stage)
    {
        super(stage);
    }

    public Scene getScene()
    {
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);

        // Creates labels, image, and buttons
        Label label = new Label("Surgery Simulator");
        start = new Button("Start");
        exit = new Button("Exit");
        ImageView image = new ImageView(new Image("file:src/Surgeon .png"));
        image.setFitHeight(150);
        image.setFitWidth(300);
        


        // Adds the objects to the box, then to the scene, and returns it
        vBox.getChildren().addAll(image, label, start, exit);
        Scene scene = new Scene(vBox, 720, 540);
        return scene;
    }

    public void buttonActivation()
    {
        // When start button is pressed
        EventHandler<ActionEvent> eventStart = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                switchScene(new CharacterCreation(primaryStage));
            } 
        };

        start.setOnAction(eventStart);

        // When exit button is pressed
        EventHandler<ActionEvent> eventExit = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                System.exit(0);
            } 
        };

        exit.setOnAction(eventExit);
    }
    

}