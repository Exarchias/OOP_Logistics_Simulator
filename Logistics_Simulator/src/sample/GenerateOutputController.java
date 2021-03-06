package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GenerateOutputController implements Initializable {

    int indexNumberPerson = 0;
    int indexNumberProduct = 0;
    int indexNumberPerson2 = 0;
    int days = 0;
    int multiplicator = 1; //multiplies each person of the population by that number
    ArrayList<Person> temporaryPersonsForDisplay; //this is for NOT using the one we have from DataHolder.
    ArrayList<Person> temporaryPersonsForOutput = new ArrayList<>(); //This for filling it with users that are meant
    //to be sent to the generated outcome.

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            temporaryPersonsForDisplay = new ArrayList<>();
            temporaryPersonsForDisplay.add(new Person("average person"));
            daysTextField.setText(String.valueOf(1000));
            multiplicatorTextField.setText(String.valueOf(1000));

        } else{
            temporaryPersonsForDisplay = DataHolder.persons;
            daysTextField.setText(String.valueOf(days));
        }
        //temporaryPersonsForDisplay = DataHolder.persons;
        displayListViewPerson();
        displayListViewProduct();
        displayListViewPerson2();
        titleTextField.setText("The output of " + DataHolder.simulationInFocus.getTitle());
        System.out.println("You are in the generate output scene!");

    }
    @FXML
    private Button btnAssignProductToPerson;

    @FXML
    private Button btnAddPersonToGeneration;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField daysTextField;

    @FXML
    private TextField multiplicatorTextField;

    @FXML
    private ListView<String> personListView;

    @FXML
    private ListView<String> productListView;

    @FXML ListView<String> personListView2;

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
    public void assignProductToPerson()throws Exception{
        Person person = temporaryPersonsForDisplay.get(indexNumberPerson);
        Product product = DataHolder.products.get(indexNumberProduct);

        person.products.add(product);
        //DataHolder.products.add(indexNumberPerson,product);
       // temporaryPersonsForDisplay.add(indexNumberProduct,person);

        //displayListViewPerson();

    }
    @FXML
    public void addPersonToGeneration()throws Exception{
        Person x = temporaryPersonsForDisplay.get(indexNumberPerson);
        temporaryPersonsForOutput.add(x);
        displayListViewPerson2();


    }


    @FXML
    //this method will have to change.
    public void clickedGenerateOutput() throws Exception {
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            days = 1000;
            multiplicator = 1000;
            String title = titleTextField.getText(); //this will stay as it is
            if(multiplicator > 1){
                ArrayList<Person> tmpPersons = new ArrayList<>();
                for(int x = 0; x < multiplicator; x++ ){
                    Person tmpPerson = new Person("Average Person #" + x);
                    //2% times 100 days
                    tmpPerson.products.add(new Product("Intensive Care Unit", 0.002));
                    tmpPersons.add(tmpPerson);
                }
                RTools.generateOutput(title, days, tmpPersons);
            } else {
                RTools.generateOutput(title, days, temporaryPersonsForOutput);
            }
        } else {
            days = Integer.parseInt(daysTextField.getText());
            multiplicator = Integer.parseInt(multiplicatorTextField.getText());
            String title = titleTextField.getText(); //this will stay as it is
            if(multiplicator > 1){
                ArrayList<Person> tmpPersons = new ArrayList<>();
                for(Person person : temporaryPersonsForOutput){
                    for(int x = 0; x < multiplicator; x++ ){
                        Person tmpPerson = person;
                        tmpPersons.add(tmpPerson);
                    }
                }
                RTools.generateOutput(title, days, tmpPersons);
            } else {
                RTools.generateOutput(title, days, temporaryPersonsForOutput);
            }
        }
        //DataHolder.personInFocus = DataHolder.persons.get(indexNumberPerson); //this will have to leave
        //DataHolder.productInFocus = DataHolder.products.get(indexNumberProduct); //this will have to leave
        RTools.goToScene("outputDisplay");
    }

    @FXML
    public void somethingIsSelectedPerson(MouseEvent event) throws Exception {
        indexNumberPerson = personListView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    public void somethingIsSelectedProduct(MouseEvent event) throws Exception {
        indexNumberProduct = productListView.getSelectionModel().getSelectedIndex();
    }

    @FXML
    public void somethingIsSelectedPerson2(MouseEvent event)throws Exception{
        indexNumberPerson2 = personListView2.getSelectionModel().getSelectedIndex();
    }

    //Displays the content of an array to the ListView. Tricky method. the idea is that you change only the array list
    //and the ListView and keep everything else in place.
    //Lavdim leave this method as it is. We have only one ArrayList at the moment.
    public void displayListViewPerson(){
        personListView.getItems().clear();
        if(!temporaryPersonsForDisplay.isEmpty()){ //change the arraylist here.
            for (Person person : temporaryPersonsForDisplay){ //change this here
                personListView.getItems().add(person.getName());
            }
        } else {
            personListView.getItems().add("The list is empty");
        }
        personListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public void displayListViewProduct(){
        productListView.getItems().clear();
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            productListView.getItems().add("Intensive Care Unit");
        } else {
            if(!DataHolder.products.isEmpty()){ //change the arraylist here.
                for (Product product : DataHolder.products){ //change this here
                    productListView.getItems().add(product.getTitle());
                }
            } else {
                productListView.getItems().add("The list is empty");
            }
        }

        productListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    public void displayListViewPerson2(){
        personListView2.getItems().clear();
        if(DataHolder.simulationInFocus.isResearchQuestion()){
            personListView2.getItems().add("average person");
        } else {
            if (!temporaryPersonsForOutput.isEmpty()){
                for (Person person:temporaryPersonsForOutput){
                    personListView2.getItems().add(person.getName());
                }
            }else {
                personListView2.getItems().add("The personlist2 is empty");
            }
        }
        personListView2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


}
