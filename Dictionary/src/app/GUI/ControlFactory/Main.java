package app.GUI.ControlFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dictionary.fxml"));
        primaryStage.setTitle("dictionary");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] arg)  {
        launch(arg);
    }
}
