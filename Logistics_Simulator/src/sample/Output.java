package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Output {
    private String title = "an output";
    private Simulation simulation;
    private int days = 0;
    public ArrayList<Person> persons = new ArrayList<>();
    public ArrayList<String> logs = new ArrayList<>();
    HashMap<String, Integer> quantities = new HashMap<>();

    public Output(String title, int days) {
        this.title = title;
        this.days = days;
        this.simulation = DataHolder.simulationInFocus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    //When it is called, (once per day), it adds an item to each user for each product the user has.
    void itemForTheDay(int day){
        //System.out.println("itemForTheDay() runs");
        for(Person person : persons){
            //System.out.println("it loops through all the persons");
            for(Product product : person.products){
                //System.out.println("it loops through the persons items");
                person.items.add(product.generateItem());
                countQuantity(product.getTitle(), 1);
                logs.add("Day:" + day + " The item " + product.getTitle() +  " was given to " + person.getName());
                //System.out.println("Day:" + day + " The item " + product.getTitle() +  " was given to " + person.getName());
            }
        }
    }

    void itemsForTheDays(){
        for(int x=0; x<days; x++){
            //System.out.println("Day: " + x);
            itemForTheDay(x);
        }
    }

    String displayLogs(){
        String msg = "";
        for(String x: logs){
            msg = msg + x + "\n";
        }
        return msg;
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
