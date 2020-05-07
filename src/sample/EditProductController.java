package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProductController implements Initializable {

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the create product scene!");
        nameTextField.setText(DataHolder.productInFocus.getTitle());
    }

    @FXML
    TextField nameTextField;

    @FXML
    Button submitBtn;

    @FXML
    Button toDashboardBtn;


    @FXML
    public void clickedOnSubmit() {
        String text = nameTextField.getText();
        if (!text.equalsIgnoreCase("")) {
            RTools.editAProduct(text);
        } else {
            RTools.editAProduct("Defeault Product");
        }

    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }


}
