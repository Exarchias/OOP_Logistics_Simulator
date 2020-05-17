package sample;

import java.util.ArrayList;

public class Person {
    private String name = "John Doe";
    public ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
