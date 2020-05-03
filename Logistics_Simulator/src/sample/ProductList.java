package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductList {

    private SimpleIntegerProperty productId;
    private SimpleStringProperty productName;
    private SimpleStringProperty  productType;
    private SimpleStringProperty  manufacturedDate;
    private SimpleStringProperty  expiredDate;
    private SimpleDoubleProperty productPrice;

    public ProductList(int productId, String productName, String productType, String manufacturedDate, String expiredDate, double productPrice) {
        this.productId = new SimpleIntegerProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.productType = new SimpleStringProperty(productType);
        this.manufacturedDate = new SimpleStringProperty(manufacturedDate);
        this.expiredDate = new SimpleStringProperty(expiredDate);
        this.productPrice = new SimpleDoubleProperty(productPrice);
    }



    public String getProductType() {
        return productType.get();
    }

    public void setProductType(String productType) {
        this.productType.set(productType);
    }

    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public int getProductId() {
        return productId.get();
    }

    public void setProductId(int productId) {
        this.productId.set(productId);
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice.set(productPrice);
    }

    public String getManufacturedDate() {
        return manufacturedDate.get();
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate.set(manufacturedDate);
    }

    public String getExpiredDate() {
        return expiredDate.get();
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate.set(expiredDate);
    }


}
