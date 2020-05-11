package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditSimulationController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        simulationTxtField.setText(DataHolder.simulationInFocus.getTitle());
    }

    @FXML
    private TextField simulationTxtField;

    @FXML
    private Button submitBtn;

    @FXML
    private Button goToDashboarBtn;

    @FXML
    public void clickedOnSubmit(){
        String title = simulationTxtField.getText();

        //The old check is stored here: (title.length()<3||!title.matches("[a-zA-Z ,]+"))
        //It is necessary for someone to be able to give number to its simulations.
        //The thing with the length is very clever though
        if (title.length()<3){
            simulationTxtField.clear();
            simulationTxtField.setPromptText("Please write an appropriate title");
        } else {
            RTools.editASimulation(title);

        }


    }
  @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }
}
