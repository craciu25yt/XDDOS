package XD.XDDOS.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {  

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception { // a stage in JavaFX is a GUI window
        String styleSheet = getClass().getResource("scene1.css").toExternalForm(); // this gets the CSS code

        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml")); // this loads the scene from the FXML file
        Scene scene = new Scene(root); // a scene is the place where everything is shown

        scene.getStylesheets().add(styleSheet); // this sets the CSS code as a style sheet for the scene
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}