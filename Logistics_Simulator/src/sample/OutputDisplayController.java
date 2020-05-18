package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class OutputDisplayController implements Initializable {

    int indexNumber = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the outputs' GUI scene!");
        displayTextArea.setText(Display.displayDetailedOutput(DataHolder.outputInFocus));
    }

    @FXML
    TextArea displayTextArea;

    @FXML
    Button logsBtn;

    @FXML
    Button mode1Btn;

    @FXML
    Button mode2Btn;

    @FXML
    Button mode3Btn;

    @FXML
    Button logoutBtn;

    @FXML
    Button goToDashboardBtn;

    @FXML
    public void clickedOnLogout() throws Exception {
        RTools.logout();
    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }


    @FXML
    public void clickedMode1() {
        displayTextArea.setText(Display.displayDetailedOutput(DataHolder.outputInFocus));
    }

    @FXML
    public void clickedMode2(){
        displayTextArea.setText(Display.displayExtraDetailedOutput(DataHolder.outputInFocus));
    }

    @FXML
    public void clickedMode3(){
        displayTextArea.setText(Display.displaySuperExtraDetailedOutput(DataHolder.outputInFocus));
    }

    @FXML
    public void clickedLogs(){
        displayTextArea.setText(DataHolder.outputInFocus.displayLogs());
    }

}
