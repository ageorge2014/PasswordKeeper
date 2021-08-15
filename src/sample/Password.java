package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Password extends Application {

    Stage window;
    Scene scene1, scene2;
    Button button1;
    Button button2;
    ListView<String> listView;

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;

        Database db = new Database();

        window.setTitle("Password Keeper");

        //create another method to check if text field contains master password.
        button1.setOnAction(e-> {db.("abby", "blahblah" );
            window.setScene(scene2);
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text t = new Text("Login");
        t.setFont(Font.font("Veranda", FontWeight.BOLD, 20));
        grid.add(t, 0, 0, 2, 1);

        Label userName = new Label("User Name");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        grid.setGridLinesVisible(true);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);


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

    public static void main(String[] args) {
        launch(args);
    }
}
