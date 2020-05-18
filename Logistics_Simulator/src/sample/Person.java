package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Person {
    private String name = "John Doe";
    public ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    public HashMap<String, Integer> quantities = new HashMap<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //counts the quantity of consumed items
    void countQuantity(String itemName, int itemCount){
        if(!quantities.containsKey(itemName)){
            quantities.put(itemName, itemCount);
        } else {
            quantities.put(itemName, quantities.get(itemName) + itemCount);
        }
    }


    //display the quantity of all items
    String displayquantities(){
        String msg = "ITEMS \n";
        msg = msg + " ===== \n";
        if (quantities.isEmpty()) {
            msg = msg + "no items were consumed";
        }

        else {
            Iterator it = quantities.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                msg = msg + pair.getKey() + ": " + pair.getValue() + " items \n";
                //System.out.println(pair.getKey() + " = " + pair.getValue());
            }
        }
        return  msg;
    }
}
