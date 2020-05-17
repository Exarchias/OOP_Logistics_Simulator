package sample;

import java.util.ArrayList;

public class Output {
    private String title = "an output";
    private Simulation simulation;
    private int days = 0;
    public ArrayList<Person> persons = new ArrayList<>();
    public ArrayList<String> logs = new ArrayList<>();

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

    void displayLogs(){
        for(String x: logs){
            System.out.println(x);
        }
    }
}
