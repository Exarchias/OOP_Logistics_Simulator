package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PersonGUIController implements Initializable {
    int indexNumber = 0;

    @FXML
    ListView<String> personListView;

    @FXML
    Button logoutBtn;

    @FXML
    Button toDashboardBtn;

    @FXML
    Button createPersonBtn;

    @FXML
    Button editPersonBtn;

    @FXML
    Button deletePersonBtn;

    //All the scenes should implement the Initializable interface
    //The code inside initialize is the one that runs when the scene is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //some code that starts in the loading of the scene
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the persons' GUI scene!");
        displayListView();
    }

    @FXML
    public void clickedOnLogout() throws Exception {
        RTools.logout();
    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
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
    public void clickedDeletePerson() throws Exception {
        RTools.deletePerson(indexNumber);
    }

    //Displays the content of an array to the ListView. Tricky method. the idea is that you change only the array list
    //and the ListView and keep everything else in place.
    //Lavdim leave this method as it is. We have only one ArrayList at the moment.
    public void displayListView(){
        if(!DataHolder.persons.isEmpty()){ //change the arraylist here.
            for (Person person : DataHolder.persons){ //change this here
                personListView.getItems().add(person.getName());
            }
        } else {
            personListView.getItems().add("The list is empty");
        }
        personListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


}
