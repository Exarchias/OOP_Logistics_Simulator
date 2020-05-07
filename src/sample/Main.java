package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage; //multiple scenes configuration
    private static Main instance = null; //multiple scenes configuration

    @Override
    public void start(Stage primaryStage) throws Exception{
        instance = this; //multiple scenes configuration
        this.primaryStage = primaryStage;//multiple scenes configuration
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        RTools.startScript(); //initializes the application correctly
        launch(args);
    }


    //multiple scenes configuration
    //This method is the one that loads the new scene.
    public void setScene(String nameOfScene) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(nameOfScene + ".fxml"));
        root.getStylesheets().add(getClass().getResource(nameOfScene + ".fxml").toExternalForm());

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

    }

    //multiple scenes configuration
    //This method helps setCene by transfering the details of the instance.
    //By doing that we endure that all the scenes are inherit from the same instance
    public static Main getInstance() {
        return instance;
    }
}
