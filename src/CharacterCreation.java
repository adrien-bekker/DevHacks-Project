import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CharacterCreation extends Screen
{
    private Button next;
    private TextField nameInput;

    public CharacterCreation(Stage stage)
    {
        super(stage);
    }

    public Scene getScene()
    {
        // Creates a VBox
        VBox vbox = new VBox(20);

        // Creates a pane with Name label and TextField
        GridPane namePane = new GridPane();
        Label name = new Label("Name: ");
        nameInput = new TextField();
        namePane.add(name, 0, 0);
        namePane.add(nameInput, 1, 0);
        namePane.setAlignment(Pos.CENTER);

        // Creates a pane with Gender options
        GridPane genderPane = new GridPane();
        ToggleGroup genderGroup = new ToggleGroup();
        Label gender = new Label("Gender: ");
        RadioButton male = new RadioButton("Male"); 
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);
        genderPane.add(gender, 0, 0);
        genderPane.add(male, 0, 1);
        genderPane.add(female, 0, 2);
        genderPane.add(other, 0, 3);
        genderPane.setAlignment(Pos.CENTER);

        // Creates a button and adds panes and button to the VBox
        next = new Button("Next");
        vbox.getChildren().addAll(namePane, genderPane, next);
        vbox.setAlignment(Pos.CENTER);

        // Creates and returns a scene with all the items
        Scene scene = new Scene(vbox, 720, 540);
        return scene;
    }

    public void buttonActivation()
    {

    }
}