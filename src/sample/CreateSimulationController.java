package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateSimulationController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the create simulation scene");

    }

    @FXML
    private TextField txtTitle;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btngotodashboard;
    @FXML
    public void clickedOnSubmit(){
        String title = txtTitle.getText();
        if (!title.equalsIgnoreCase("")){
            RTools.createASimualtion(title);
        }else {
            RTools.createASimualtion("Default Simulation");
        }


    }
     @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }
}


