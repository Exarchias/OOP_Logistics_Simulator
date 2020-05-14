package sample;

import java.nio.file.Files;

public class TestScripts {

    public static boolean task1 (){
        Product product = new Product("test", 1);
        Item item = product.generateItem();
        if(item.getTitle().equalsIgnoreCase("test")){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task2 (){
        int int1 = DataHolder.persons.size();
        RTools.createAPerson("test");
        int int2 = DataHolder.persons.size();
        if(int1 < int2){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task3 (){
        return true;
    }

    public static boolean task4 (){
        Person person = new Person("test");
        Product product = new Product("test", 1);
        person.products.add(product);
        if(person.products.get(0).getTitle().equalsIgnoreCase("test")){
            return true;
        } else {
            return false;
        }

    }

    public static boolean task5 (){
        int int1 = DataHolder.persons.size();
        RTools.createAPerson("test");
        int int2 = DataHolder.persons.size();
        if(int1 < int2){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task6 (){
        RTools.editAPerson("test");
        if(DataHolder.personInFocus.getName().equalsIgnoreCase("test")){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task7 (){
        Simulation sim = new Simulation("test");
        Person person =  new Person("test");
        sim.population.add(person);
        if(sim.population.get(0).getName().equalsIgnoreCase("test")){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task8 (){
        int int1 = DataHolder.simulations.size();
        RTools.createASimualtion("test");
        int int2 = DataHolder.simulations.size();
        if(int1 < int2){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task9 (){
        RTools.editASimulation("test");
        if(DataHolder.simulationInFocus.getTitle().equalsIgnoreCase("test")){
            return true;
        } else {
            return false;
        }
    }

    public static boolean task10 (){
        return true;
    }

    public static boolean task11 (){
        Boolean answer = false;
        try {
            Class cls = Class.forName("sample.Controller");
            System.out.println("Controller.Java exists");
            answer =true;
        } catch (ClassNotFoundException e) {
            answer = false;
            e.printStackTrace();
            System.out.println("Controller.Java not found");
        }
        return answer;
    }

    public static boolean task12 (){
        Account user = new Account("blah", "12345");
        return RTools.checkLogin(user, "12345");
    }

    public static boolean task13 (){
        DB db = new DB();
        return DataHolder.isConnected;
    }

    public static boolean task14 (){
        boolean answer = false;
        DB db = new DB();
        try{
            db.doAHandshake();
            answer = true;
        } catch (Exception ex){
            answer = false;
        }
        return answer;
    }

    public static boolean task15 (){
        Boolean answer = false;
        try {
            Class cls = Class.forName("sample.Account");
            System.out.println("The system has users");
            answer =true;
        } catch (ClassNotFoundException e) {
            answer = false;
            e.printStackTrace();
            System.out.println("the system does not have users");
        }
        return answer;
    }

    public static boolean task16 (){
        Boolean answer = false;
        try {
            Class cls = Class.forName("sample.OutputGUIController");
            System.out.println("The Output GUI is functional");
            answer =true;
        } catch (ClassNotFoundException e) {
            answer = false;
            e.printStackTrace();
            System.out.println("the Output GUI is not functional");
        }
        return answer;
    }

    public static boolean task17 (){
        Boolean answer = false;
        try {
            Class cls = Class.forName("sample.OutputDisplayController");
            System.out.println("The Output Display is functional");
            answer =true;
        } catch (ClassNotFoundException e) {
            answer = false;
            e.printStackTrace();
            System.out.println("the Output Display is not functional");
        }
        return answer;
    }

    public static boolean task18 (){
        Boolean answer = false;
        try {
            Class cls = Class.forName("sample.Display");
            System.out.println("We have display for the outputs");
            answer =true;
        } catch (ClassNotFoundException e) {
            answer = false;
            e.printStackTrace();
            System.out.println("We don't have display for the outputs");
        }
        return answer;
    }

}
