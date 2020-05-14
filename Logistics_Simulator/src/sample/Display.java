package sample;

import java.util.ArrayList;

public class Display {



    //For displaying the details of a person
    public static String displayPerson(Person person){
        String msg= "";
        msg = "Name: " + person.getName();
        return msg;
    }


    //For displaying the details of a product
    public static String displayProduct(Product product){
        String msg= "";
        msg = "Title: " + product.getTitle();
        return msg;
    }

    //For displaying the details of a simulation
    public static String displaySimulation(Simulation simulation){
        String msg= "";
        msg = "Title: " + simulation.getTitle();
        return msg;
    }

    //For displaying the details of a output
    public static String displayOutput(Output output){
        String msg= "";
        msg = "Title: " + output.getTitle();
        return msg;
    }




    //displays the contents of an ArrayList of products
    public static String displayProductsList(ArrayList<Product> productsList){
        String msg= "";
        int count = 0;
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Product x : productsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        return msg;
    }


    //displays the contents of an ArrayList of persons
    public static String displayPersonsList(ArrayList<Person> personsList){
        String msg= "";
        int count = 0;
        msg = msg + "Persons \n";
        msg = msg + "======= \n";
        for(Person x : personsList){
            count++;
            msg = msg + "" + count + ")" + x.getName() + "\n";
        }
        return msg;
    }


    //displays the contents of an ArrayList of simulations
    public static String displaySimulationsList(ArrayList<Simulation> simulationsList){
        String msg= "";
        int count = 0;
        msg = msg + "Simulations \n";
        msg = msg + "=========== \n";
        for(Simulation x : simulationsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        return msg;
    }


    //displays the contents of an ArrayList of outputs
    public static String displayOutputsList(ArrayList<Output> outputsList){
        String msg= "";
        int count = 0;
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Output x : outputsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        return msg;
    }


}
