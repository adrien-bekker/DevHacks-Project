import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Screen 
{
    protected Stage primaryStage;
    

    public Screen(Stage stage)
    {
        primaryStage = stage;
    }

    /*public void switchScene(Screen nextScreen)
    {
        primaryStage.setScene(nextScreen.getScene());
    }*/
}