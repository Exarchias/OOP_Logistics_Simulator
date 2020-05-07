package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GenerateOutputController implements Initializable {

    int indexNumberPerson = 0;
    int indexNumberProduct = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        displayListViewPerson();
        displayListViewProduct();
        titleTextField.setText("The output of " + DataHolder.simulationInFocus.getTitle());
        System.out.println("You are in the generate output scene!");

    }



    @FXML
    private TextField titleTextField;

    @FXML
    private ListView<String> personListView;

    @FXML
    private ListView<String> productListView;

    @FXML
    private Button generateBtn;

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
    public void clickedGenerateOutput() throws Exception {
        DataHolder.personInFocus = DataHolder.persons.get(indexNumberPerson);
        DataHolder.productInFocus = DataHolder.products.get(indexNumberProduct);
        String title = titleTextField.getText();
        RTools.generateOutput(title);
    }

    @FXML
    public void somethingIsSelectedPerson(MouseEvent event) throws Exception {
        indexNumberPerson = personListView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    public void somethingIsSelectedProduct(MouseEvent event) throws Exception {
        indexNumberProduct = productListView.getSelectionModel().getSelectedIndex();
    }

    //Displays the content of an array to the ListView. Tricky method. the idea is that you change only the array list
    //and the ListView and keep everything else in place.
    //Lavdim leave this method as it is. We have only one ArrayList at the moment.
    public void displayListViewPerson(){
        personListView.getItems().clear();
        if(!DataHolder.persons.isEmpty()){ //change the arraylist here.
            for (Person person : DataHolder.persons){ //change this here
                personListView.getItems().add(person.getName());
            }
        } else {
            personListView.getItems().add("The list is empty");
        }
        personListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void displayListViewProduct(){
        productListView.getItems().clear();
        if(!DataHolder.products.isEmpty()){ //change the arraylist here.
            for (Product product : DataHolder.products){ //change this here
                productListView.getItems().add(product.getTitle());
            }
        } else {
            productListView.getItems().add("The list is empty");
        }
        productListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}