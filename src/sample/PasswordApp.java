package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordApp extends Application {

    Stage window;
    Scene scene1, scene2;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Database db = new Database();

        //ask user to enter password. create text field

        Label label1 = new Label("This is the first scene!");
        Button button1 = new Button("LOGIN");
        //once button
        //create another method to check if text field contains master password.
        button1.setOnAction(e-> {db.signup("abby", );
            window.setScene(scene2);
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);

        scene1 = new Scene(layout1, 300, 250);

        //Button2
        Button button2 = new Button("Search");
        button2.setOnAction(e-> window.setScene(scene1));

        listView = new ListView<>();
        listView.getItems().addAll("john", "abby", "karen");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(listView, button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("Password Keeper");
        window.show();
    }
}
