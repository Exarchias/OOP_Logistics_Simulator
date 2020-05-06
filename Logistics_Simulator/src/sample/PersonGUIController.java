package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonGUIController implements Initializable {

    @FXML
    Button logoutBtn;

    @FXML
    Button toDashboardBtn;

    @FXML
    Button createPersonBtn;

    @FXML
    Button editPersonBtn;

    @FXML
    Button deletePersonBtn;

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the persons' GUI scene!");
    }

    @FXML
    public void clickedOnLogout() throws Exception {
        RTools.logout();
    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }

    @FXML
    public void clickedCreatePerson() throws Exception {
        RTools.goToScene("createPerson");
    }

    @FXML
    public void clickedEditPerson() throws Exception {
        RTools.goToScene("editPerson");
    }


}
