package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    Button logoutBtn;

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        System.out.println("You are logged in!");
    }

    @FXML
    public void clickedOnLogout() throws Exception {
        Main.getInstance().setScene("sample"); //this little line does the transition to the other scene.
    }
}
