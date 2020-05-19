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
        //displayTextArea.setText(Display.displayDetailedOutput(DataHolder.outputInFocus));
        String msg = "";
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            //displayTextArea.setText(Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.get("Intensive Care Unit")));
            msg = msg + Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.
                    get("Intensive Care Unit")) + " \n";
        }
        //displayTextArea.setText(Display.displayDetailedOutput(DataHolder.outputInFocus));
        msg = msg + Display.displayDetailedOutput(DataHolder.outputInFocus) + " \n";
        displayTextArea.setText(msg);
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
        String msg = "";
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            //displayTextArea.setText(Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.get("Intensive Care Unit")));
            msg = msg + Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.
                    get("Intensive Care Unit")) + " \n";
        }
        //displayTextArea.setText(Display.displayDetailedOutput(DataHolder.outputInFocus));
        msg = msg + Display.displayDetailedOutput(DataHolder.outputInFocus) + " \n";
        displayTextArea.setText(msg);
    }

    @FXML
    public void clickedMode2(){
        String msg = "";
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            //displayTextArea.setText(Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.get("Intensive Care Unit")));
            msg = msg + Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.
                    get("Intensive Care Unit")) + " \n";
        }
        msg = msg + Display.displayExtraDetailedOutput(DataHolder.outputInFocus) + " \n";
        //displayTextArea.setText(Display.displayExtraDetailedOutput(DataHolder.outputInFocus));
        displayTextArea.setText(msg);
    }

    @FXML
    public void clickedMode3(){
        String msg = "";
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            //displayTextArea.setText(Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.get("Intensive Care Unit")));
            msg = msg + Display.displayresearchQuestion(DataHolder.outputInFocus.quantities.
                    get("Intensive Care Unit")) + " \n";
        }
        //displayTextArea.setText(Display.displaySuperExtraDetailedOutput(DataHolder.outputInFocus));
        msg = msg + Display.displaySuperExtraDetailedOutput(DataHolder.outputInFocus) + " \n";
        displayTextArea.setText(msg);
    }

    @FXML
    public void clickedLogs(){
        displayTextArea.setText(DataHolder.outputInFocus.displayLogs());
    }

}
