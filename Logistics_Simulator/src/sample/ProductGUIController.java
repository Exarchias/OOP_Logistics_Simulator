package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductGUIController implements Initializable {
    int indexNumber = 0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RTools.kickIfNotLoggedIn();
        System.out.println("You are in the products' GUI scene!");
    }

    @FXML
    private ListView<String> productListView;

    @FXML
    private Button createProductBtn;

    @FXML
    private Button editProductBtn;

    @FXML
    private Button deleteProductBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button toDashboardBtn;

    @FXML
    public void clickedOnLogout() throws Exception {
        RTools.logout();
    }

    @FXML
    public void clickedOnToDashboard() throws Exception {
        RTools.goToDashBoard();
    }

    @FXML
    public void clickedCreateProduct() throws Exception {
        RTools.goToScene("createProduct");
    }

    @FXML
    public void clickedEditProduct() throws Exception {
        RTools.goToScene("editProduct");
    }

    @FXML
    public void clickedDeleteProduct() throws Exception {
       RTools.deleteProduct(indexNumber);
    }
}
