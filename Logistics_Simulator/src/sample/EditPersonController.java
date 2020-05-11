package sample;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPersonController implements Initializable {

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the edit person scene!");
        nameTextField.setText(DataHolder.personInFocus.getName());
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
        //It is necessary for someone to be able to give number to its personss.
        //The thing with the length is very clever though
        if (text.length()<3){
            //nameTextField.setText(DataHolder.personInFocus.getName());
              nameTextField.clear();
            nameTextField.setPromptText("Please write an appropriate name");
        } else {
            RTools.editAPerson(text);

        }



    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }


}
