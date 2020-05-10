package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Robert: This will be the very first page. We will use it as a login page
    //but let's leave it with a generic name, just to highlight that it will be the very first page.

    @FXML
    Button loginBtn;

    @FXML
    private TextField txtFieldUserName;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Label lblstatus;

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        System.out.println("You are NOT logged In!");

    }

    @FXML
    public void clickedOnLogin() throws Exception {

        Account account;
        if (DataHolder.userNameExists(txtFieldUserName.getText()))

        {
            account = RTools.findUserByUsername(txtFieldUserName.getText());

            if (RTools.checkLogin(account,txtpassword.getText())) {
                DataHolder.activeUser = account;
                DataHolder.userInFocus = account;

                DataHolder.setLoggedIn(true);
                // DataHolder.isAdmin = user.isAdmin();
                //move to new activity. This little part maybe in need of small edit,
                // (depends on the Activity which it is in)
                // change an activity when user logged in send to User page // tell to @Abdi
                RTools.goToDashBoard();




            }
            else {
                DataHolder.setLoggedIn(false);
                txtFieldUserName.clear();
                txtpassword.clear();
                //RTools.goToDashBoard();
                lblstatus.setText("Please write the correct password");
             //   System.out.println("Please write the correct password");

            }
        }else {
            //RTools.goToScene("dashboard");
            DataHolder.setLoggedIn(false);
            txtFieldUserName.clear();
            txtpassword.clear();
           // RTools.goToDashBoard();
            lblstatus.setText("Please write the correct username");
           // System.out.println("Please write the correct username");
        }


    }

    public void registerButtonPressed() throws Exception {
        Main.LoadRegisterView();


    }
}



