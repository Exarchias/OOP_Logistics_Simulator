package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateProductController implements Initializable {

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the create product scene!");
    }

    @FXML
    TextField nameTextField;

    @FXML
    Button submitBtn;

    @FXML
    Button toDashboardBtn;


    @FXML
    public void clickedOnSubmit(){
        String text = nameTextField.getText();
        if(!text.equalsIgnoreCase("")){
            RTools.createAPerson(text);
        } else {
            RTools.createAPerson("Robert");
        }

    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }


}
