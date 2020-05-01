package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Robert: This will be the very first page. We will use it as a login page
    //but let's leave it with a generic name, just to highlight that it will be the very first page.

    @FXML
    Button loginBtn;

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        System.out.println("You are NOT logged In!");
    }

    @FXML
    public void clickedOnLogin() throws Exception {
        RTools.goToScene("dashboard");
    }



}
