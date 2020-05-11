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
        nameTextField.setPromptText("Name of product");
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
        //The old check is stored here: (title.length()<3||!title.matches("[a-zA-Z ,]+"))
        //It is necessary for someone to be able to give number to its products.
        //The thing with the length is very clever though
        if (text.length()<3){
            nameTextField.clear();
            nameTextField.setPromptText("Please write an appropriate product name");
        } else {
            RTools.createAProduct(text);

        }



    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }


}
