import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application 
{
    @Override
    public void start(Stage primaryStage)
    {
        MainMenu start = new MainMenu(primaryStage);
        primaryStage.setScene(start.getScene());
        start.buttonActivation();
        primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
