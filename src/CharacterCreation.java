import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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

        // Title
        GridPane pane = new GridPane();
        Label title = new Label("Create Your Character! \n");
        title.setStyle("-fx-font-weight: bold; -fx-font-size: 24;");
        title.setTextFill(Color.DARKGOLDENROD);
        pane.add(title, 0, 0);
        pane.setAlignment(Pos.CENTER);

        // Creates a pane with Name label and TextField
        GridPane namePane = new GridPane();
        Label name = new Label("Name: ");
        name.setStyle("-fx-font-weight: bold; -fx-font-size: 15");
        nameInput = new TextField();
        namePane.add(name, 1, 0);
        namePane.add(nameInput, 2, 0);
        namePane.setAlignment(Pos.CENTER);

        // Creates a pane with Gender options
        GridPane genderPane = new GridPane();
        ToggleGroup genderGroup = new ToggleGroup();
        Label gender = new Label("Gender: ");
        gender.setStyle("-fx-font-weight: bold; -fx-font-size: 15");
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

        // Creates background and sets button color
        BackgroundFill backFill = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);
        Background back = new Background(backFill);
        vbox.setBackground(back);
        BackgroundFill buttonFill = new BackgroundFill(Color.rgb(227, 230, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background buttonBack = new Background(buttonFill);
        next = new Button("Next");
        next.setBackground(buttonBack);

        // Creates a button and adds panes and button to the VBox
        vbox.getChildren().addAll(pane, namePane, genderPane, next);
        vbox.setAlignment(Pos.CENTER);

        // Creates and returns a scene with all the items
        Scene scene = new Scene(vbox, 720, 540);
        return scene;
    }

    public void buttonActivation()
    {
        // When next button is pressed
        EventHandler<ActionEvent> eventNext = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                String player = nameInput.getText();
                level1Info info = new level1Info(primaryStage, player);
                switchScene(info);
            } 
        };
        
        next.setOnAction(eventNext);
    }
}