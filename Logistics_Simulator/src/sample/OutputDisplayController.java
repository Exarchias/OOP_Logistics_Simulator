package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class OutputDisplayController implements Initializable {

    int indexNumber = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        displayListView();
        System.out.println("You are in the outputs' GUI scene!");

    }


    @FXML
    private Button deleteOutputBtn;

    @FXML
    private ListView<String> outputListView;

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
    public void clickedDeleteOutput() throws Exception {
        RTools.deleteOutput(indexNumber);
        displayListView();
    }

    @FXML
    public void somethingIsSelectedOnListView(MouseEvent event) throws Exception {
        indexNumber = outputListView.getSelectionModel().getSelectedIndex();
    }

    //Displays the content of an array to the ListView. Tricky method. the idea is that you change only the array list
    //and the ListView and keep everything else in place.
    //Lavdim leave this method as it is. We have only one ArrayList at the moment.
    public void displayListView(){
        outputListView.getItems().clear();
        if(!DataHolder.outputs.isEmpty()){ //change the arraylist here.
            for (Output output : DataHolder.outputs){ //change this here
                outputListView.getItems().add(output.getTitle());
            }
        } else {
            outputListView.getItems().add("The list is empty");
        }
        outputListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
