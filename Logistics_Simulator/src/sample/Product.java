package sample;

import java.util.ArrayList;

public class Product {
    private String title = "A product";
    private double consumptionRate = 1; //Decided to have it double because it can go fractional

    public Product(String title, double consumptionRate) {
        this.title = title;
        this.consumptionRate = consumptionRate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public Item generateItem(){
        Item item = new Item(title);
        return item;
    }
}
