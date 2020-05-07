package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SimulationGUIController implements Initializable {

    int indexNumber = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        displayListView();
        System.out.println("You are in the simulations' GUI scene!");

    }

    @FXML
    private Button createSimulationBtn;

    @FXML
    private Button editSimulationBtn;

    @FXML
    private Button deleteSimulationBtn;

    @FXML
    private Button generateOutputBtn;

    @FXML
    private ListView<String> simulationListView;

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
        DataHolder.simulationInFocus = DataHolder.simulations.get(indexNumber);
        RTools.goToScene("editSimulation");
    }

    @FXML
    public void clickedDeleteSimulation() throws Exception {
        RTools.deleteSimulationt(indexNumber);
        displayListView();
    }

    @FXML
    public void clickedGenerateOutput() throws Exception {
        DataHolder.simulationInFocus = DataHolder.simulations.get(indexNumber);
        RTools.goToScene("generateoutput");
    }

    @FXML
    public void somethingIsSelectedOnListView(MouseEvent event) throws Exception {
        indexNumber = simulationListView.getSelectionModel().getSelectedIndex();
    }

    //Displays the content of an array to the ListView. Tricky method. the idea is that you change only the array list
    //and the ListView and keep everything else in place.
    //Lavdim leave this method as it is. We have only one ArrayList at the moment.
    public void displayListView(){
        simulationListView.getItems().clear();
        if(!DataHolder.simulations.isEmpty()){ //change the arraylist here.
            for (Simulation sim : DataHolder.simulations){ //change this here
                simulationListView.getItems().add(sim.getTitle());
            }
        } else {
            simulationListView.getItems().add("The list is empty");
        }
        simulationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
