package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.security.NoSuchAlgorithmException;

public class Main extends Application {

    private static Stage primaryStage; //multiple scenes configuration
    private static Main instance = null; //multiple scenes configuratio
    static DB db = new DB();

    @Override
    public void start(Stage primaryStage) throws Exception{
        instance = this; //multiple scenes configuration
        this.primaryStage = primaryStage;//multiple scenes configuration
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Logistics Simulator");
        primaryStage.setScene(new Scene(root, 465, 465));
        primaryStage.show();
    }


    public static void main(String[] args) {
        RTools.startScript(); //initializes the application correctly
        db.doAHandshake();
        try {
            db.loadUsers();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        launch(args);
    }


    // i need this method to change scenes in different controller classes
    private static void loadView(String nameOfView) {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource(nameOfView + ".fxml"));


            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception ex) {
            ex.printStackTrace(); //Most likely something wrong with loading files.
        }
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


    public static void LoadRegisterView() throws Exception {
        loadView("../view/RegisterAccount");

    }

}
