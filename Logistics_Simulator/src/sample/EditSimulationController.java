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

        if (title.length()<3||!title.matches("[a-zA-Z ,]+")){
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
