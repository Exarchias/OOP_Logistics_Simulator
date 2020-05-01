package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    Button logoutBtn;

    @FXML
    Button createPersonBtn;

    @FXML
    Button editPersonBtn;

    @FXML
    Button createProductBtn;

    @FXML
    Button editProductBtn;

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the dashboard!");
    }

    @FXML
    public void clickedOnLogout() throws Exception {
        RTools.logout();
    }

    @FXML
    public void clickedCreatePerson() throws Exception {
        RTools.goToScene("createPerson");
    }

    @FXML
    public void clickedEditPerson() throws Exception {
        RTools.goToScene("editPerson");
    }

    @FXML
    public void clickedCreateProduct() throws Exception {
        RTools.goToScene("createProduct");
    }

    @FXML
    public void clickedEditProduct() throws Exception {
        RTools.goToScene("editProduct");
    }






}
