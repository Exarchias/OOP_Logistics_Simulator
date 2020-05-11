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
        txtTitle.setPromptText("Name of Title");
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

        //The old check is stored here: (title.length()<3||!title.matches("[a-zA-Z ,]+"))
        //It is necessary for someone to be able to give number to its simulations.
        //The thing with the length is very clever though
        if (title.length()<3){
            txtTitle.clear();
            txtTitle.setPromptText("Please write an appropriate title");
        } else {
            RTools.createASimualtion(title);

        }



    }
     @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }
}


