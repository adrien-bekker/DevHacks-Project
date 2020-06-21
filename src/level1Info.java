import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class level1Info extends Screen {

    public level1Info(Stage stage)
    {
        super(stage);
    }

    public Scene getScene() 
    {
        // Creates pane and label
        Pane pane = new Pane();
        Label info = new Label("Hi " + player + "! you are a surgeon at Northwestern Memorial Hospital and have finished your residency." + 
                                "Your first patient has fallen off a bike and requires stitches. Click next to start your first surgery." + 
                                "The quicker you finish the game the better, however, remember to choose the right choices!");
    }

    public void buttonActivation() 
    {
        
    }

}