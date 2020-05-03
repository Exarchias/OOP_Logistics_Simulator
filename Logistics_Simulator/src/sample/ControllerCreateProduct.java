package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static sample.DBConnection.ConnectDb;

public class ControllerCreateProduct implements Initializable {

    @FXML
    private TableView<ProductList> table_product;

    @FXML
    private TableColumn<ProductList, Integer> col_productId;

    @FXML
    private TableColumn<ProductList, String> col_productName;

    @FXML
    private TableColumn<ProductList, String> col_manufacturedDate;

    @FXML
    private TableColumn<ProductList, String> col_expiredDate;

    @FXML
    private TableColumn<ProductList, Double> col_productPrice;

    @FXML
    private TableColumn<ProductList, String> col_productType;


    @FXML
    private TextField txt_productId;

    @FXML
    private TextField txt_productName;

    @FXML
    private TextField txt_manufacturedDate;

    @FXML
    private TextField txt_expiredDate;

    @FXML
    private TextField txt_productPrice;

    @FXML
    private TextField txt_productType;

    @FXML
    private TextField filterField;
    @FXML
    private Button back_dashboard;


    private DBConnection dbConnection;
    private ObservableList<ProductList> list;
    int index = -1;
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement pst = null;


    public ObservableList<ProductList> getAllProducts() {

        connection = ConnectDb();
        list = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM logisticapp.product;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new ProductList((
                        resultSet.getInt("productId")),
                        resultSet.getString("productName"),
                        resultSet.getString("productType"),
                        resultSet.getString("manufacturedDate"),
                        resultSet.getString("expiredDate"),
                        resultSet.getDouble("productPrice")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * This method can add any type of product into the product list
     */

    public void add() {
        connection = ConnectDb();
        String sql = "insert into product (productid,productname,producttype,manufactureddate,expireddate,productprice)values(?,?,?,?,?,? )";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txt_productId.getText());
            pst.setString(2, txt_productName.getText());
            pst.setString(3, txt_productType.getText());
            pst.setString(4, txt_manufacturedDate.getText());
            pst.setString(5, txt_expiredDate.getText());
            pst.setDouble(6, Double.valueOf(txt_productPrice.getText()));
            pst.execute();

            JOptionPane.showMessageDialog(null, "products add successfully");
            UpdateTable();
            search();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method helps to select any type of product in the product list
     */

    @FXML
    public void getSelected(MouseEvent event) {
        //if the the column is empty just return
        index = table_product.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        txt_productId.setText(col_productId.getCellData(index).toString());
        txt_productName.setText(col_productName.getCellData(index));
        txt_productType.setText(col_productType.getCellData(index));
        txt_manufacturedDate.setText(col_manufacturedDate.getCellData(index));
        txt_expiredDate.setText(col_expiredDate.getCellData(index));
        txt_productPrice.setText(col_productPrice.getCellData(index).toString());
    }

    /**
     * This method can edit any type of product in the product list
     */
    public void Edit() {
        try {
            connection = ConnectDb();
            String value1 = txt_productId.getText();
            String value2 = txt_productName.getText();
            String value3 = txt_productType.getText();
            String value4 = txt_manufacturedDate.getText();
            String value5 = txt_expiredDate.getText();
            String value6 = txt_productPrice.getText();
            //  String value5 = txt_type.getText();
            String sql = "update product set productid= '"
                    + value1 + "',productname= '"
                    + value2 + "',producttype= '" +
                    value3 + "',manufactureddate= '"
                    + value4 + "',expireddate= '" +
                    value5 + "',productprice= '" +
                    value6 + "' where productid='" + value1 + "' ";
            pst = connection.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method can delete any type of product from the product list
     */
    public void Delete() {
        connection = ConnectDb();
        String sql = "delete from product where productid = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, txt_productId.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method can update or refresh the whole product list from data base
     */
    public void UpdateTable() {
        setColumn();

        table_product.setItems(getAllProducts());
    }


    /**
     * This method can filter or search any product from the product list
     * by typing the matching letter from the available product
     */
    @FXML
    public void search() {
        setColumn();

        table_product.setItems(getAllProducts());

        FilteredList<ProductList> filteredData = new FilteredList<>(getAllProducts(), b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (product.getProductName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter product if matches product name

                } else if (product.getProductType().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false; // Does not match.
            });
        });
        SortedList<ProductList> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_product.comparatorProperty());
        table_product.setItems(sortedData);
    }


    /**
     * program starts here
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dbConnection = new DBConnection();
        setColumn();
        table_product.setItems(getAllProducts());

        UpdateTable();
        search();

    }

    /**
     * set the list of products on the column cell
     */

    public void setColumn() {

        //set up the columns in the table
        col_productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        col_productType.setCellValueFactory(new PropertyValueFactory<>("productType"));
        col_manufacturedDate.setCellValueFactory(new PropertyValueFactory<>("manufacturedDate"));
        col_expiredDate.setCellValueFactory(new PropertyValueFactory<>("expiredDate"));
        col_productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
    }

}
