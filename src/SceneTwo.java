import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneTwo extends Screen {

    public SceneTwo(Stage stage) {
        super(stage);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Scene getScene() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void buttonActivation() {
        // TODO Auto-generated method stub

    }
    /*private String question;
    private String[] answers, responses;
    private ToggleGroup group;
    private RadioButton button1, button2, button3, button4;
    private Button confirm;
    private int score = -1, scene1Pos = 0;
    private Scene sampleScene;
    private Label feedback;
    private LevelOne level;
    public SceneTwo(String q, String[] a, String[] r)
    {
        super(stage);
        question = q;
        answers = a;
        responses = r;
        group = new ToggleGroup();
        level = lvl;
    }

    public void setScene()
    {
        score = -1;
        Label task = new Label(question);
        feedback  = new Label(" ");

        configureB1();
        configureB2();
        configureB3();
        configureB4();
        confirm = new Button("Confirm");

        VBox pane1 = new VBox(20);
        pane1.getChildren().addAll(task, button1, button2, button3, button4, confirm, feedback);
        sampleScene = new Scene(pane1, 720, 540);
        primaryStage.setScene(sampleScene);
        buttonActivation();
        /*while(group.getSelectedToggle().equals(null))
                {
                    if(group.getSelectedToggle().equals(button1))
                    {
                        score = 3;
                        
                    }
                    else if(group.getSelectedToggle().equals(button2))
                    {
                        score = 2;
                    }
                    else if(group.getSelectedToggle().equals(button3))
                    {
                        score = 1;
                    }
                    else if(group.getSelectedToggle().equals(button4))
                    {
                        score = 0;
                    }
                } 
        
        System.out.println(group.getSelectedToggle());
        primaryStage.show();
    }

    private void configureB1()
    {
        button1 = new RadioButton(answers[0]);
        button1.setToggleGroup(group);
    }

    private void configureB2()
    {
        button2 = new RadioButton(answers[1]);
        button2.setToggleGroup(group);
    }

    private void configureB3()
    {
        button3 = new RadioButton(answers[2]);
        button3.setToggleGroup(group);
    }

    private void configureB4()
    {
        button4 = new RadioButton(answers[3]);
        button4.setToggleGroup(group);
    }

    public void buttonActivation()
    {
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                if(group.getSelectedToggle().isSelected())
                {
                    if(group.getSelectedToggle().equals(button1))
                    {
                        score = 3;
                        
                    }
                    else if(group.getSelectedToggle().equals(button2))
                    {
                        score = 2;
                    }
                    else if(group.getSelectedToggle().equals(button3))
                    {
                        score = 1;
                        feedback.setText(response[0]);
                    }
                    else if(group.getSelectedToggle().equals(button4))
                    {
                        score = 0;
                    }
                    level.sceneOneResultAndSwitch(score);
                }
                
            } 
            
        };
        confirm.setOnAction(event);
    }

    public int getScore()
    {
        return score;
    }

    public void waiter()
    {
        
    }

    @Override
    public Scene getScene() {
        // TODO Auto-generated method stub
        return null;
    }*/
}