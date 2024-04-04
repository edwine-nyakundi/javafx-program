package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonLayout extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Button Layout");

        // Create buttons
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");

        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");
        //Button btn6 = new Button("Button 6");

        // Create an HBox layout for buttons in a horizontal line
        HBox hbox1 = new HBox(btn1, btn2, btn3);
        HBox hbox2 = new HBox(btn4, btn5);
        HBox hbox3 = new HBox(btn5);
       // HBox hbox4 = new HBox(btn6);

        // Create a VBox layout to stack HBoxes vertically
        VBox vbox = new VBox(hbox1, hbox2,hbox3);
        vbox.setSpacing(10); // Set spacing between HBoxes

        // Set padding for the VBox
        vbox.setPadding(new Insets(10));

        // Create a scene with the VBox layout
        Scene scene = new Scene(vbox, 300, 200);

        // Set the scene to the stage and display the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
