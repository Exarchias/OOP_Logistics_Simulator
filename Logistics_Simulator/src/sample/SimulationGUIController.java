package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class SimulationGUIController implements Initializable {

    int indexNumber = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the simulations' GUI scene!");
    }

    @FXML
    private Button createSimulationBtn;

    @FXML
    private Button editSimulationBtn;

    @FXML
    private Button deleteSimulationBtn;

    @FXML
    private ListView<?> simulationListView;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button goToDashboardBtn;

    @FXML
    public void clickedOnLogout() throws Exception {
        RTools.logout();
    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }

    @FXML
    public void clickedCreateSimulation() throws Exception {
        RTools.goToScene("createSimulation");
    }

    @FXML
    public void clickedEditSimulation() throws Exception {
        RTools.goToScene("editSimulation");
    }

    @FXML
    public void clickedDeleteSimulation() throws Exception {
        RTools.deleteSimulationt(indexNumber);
    }
}
