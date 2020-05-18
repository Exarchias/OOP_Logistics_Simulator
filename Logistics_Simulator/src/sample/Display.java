package sample;

import java.util.ArrayList;

public class Display {



    //For displaying the details of a person
    public static String displayPerson(Person person){
        String msg= "";
        msg = msg + "Name: " + person.getName() + "\n";
        msg = msg + "Consumes " + person.products.size() + " products \n";
        msg = msg + "" + person.displayquantities() + " \n";
        msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a person
    public static String displayDetailedPerson(Person person){
        String msg= "";
        msg = msg + displayPerson(person) + "\n";
        msg = msg + displayProductsList(person.products) + "\n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a product
    public static String displayProduct(Product product){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + "Title: " + product.getTitle()+ " \n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a product
    public static String displayDetailedProduct(Product product){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + displayProduct(product) + "\n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a simulation
    public static String displaySimulation(Simulation simulation){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + "Title: " + simulation.getTitle() + " \n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a simulation
    public static String displayDetailedSimulation(Simulation simulation){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + displaySimulation(simulation) + "\n";
        msg = msg + displayPersonsList(simulation.population) + "\n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a output
    public static String displayOutput(Output output){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + "Title: " + output.getTitle() + " \n";
        msg = msg + "Belongs to " + output.getSimulation().getTitle() + " simulation. \n";
        msg = msg + "duration: " + output.getDays() + " days. \n";
        msg = msg + "" + output.displayquantities() + " \n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a output
    public static String displayDetailedOutput(Output output){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + displayOutput(output) + "\n";
        msg = msg + displayPersonsList(output.persons) + "\n";
        //msg = msg + " \n";
        return msg;
    }

    //For displaying the details of a output
    public static String displayExtraDetailedOutput(Output output){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + displayOutput(output) + "\n";
        msg = msg + displayDetailedPersonsList(output.persons) + "\n";
        //msg = msg + " \n";
        return msg;
    }


    //For displaying the details of a output
    public static String displaySuperExtraDetailedOutput(Output output){
        String msg= "";
        //msg = msg + " \n";
        msg = msg + displayOutput(output) + "\n";
        msg = msg + displayExtraDetailedPersonsList(output.persons) + "\n";
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of products
    public static String displayProductsList(ArrayList<Product> productsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Product x : productsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }

    //displays the contents of an ArrayList of products
    public static String displaydetailedProductsList(ArrayList<Product> productsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Product x : productsList){
            count++;
            msg = msg + "" + count + ")" + displayProduct(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of persons
    public static String displayPersonsList(ArrayList<Person> personsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Persons \n";
        msg = msg + "======= \n";
        for(Person x : personsList){
            count++;
            msg = msg + "" + count + ")" + x.getName() + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of persons
    public static String displayDetailedPersonsList(ArrayList<Person> personsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Persons \n";
        msg = msg + "======= \n";
        for(Person x : personsList){
            count++;
            msg = msg + "" + count + ")" + displayPerson(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }

    //displays the contents of an ArrayList of persons
    public static String displayExtraDetailedPersonsList(ArrayList<Person> personsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Persons \n";
        msg = msg + "======= \n";
        for(Person x : personsList){
            count++;
            msg = msg + "" + count + ")" + displayDetailedPerson(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of simulations
    public static String displaySimulationsList(ArrayList<Simulation> simulationsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Simulations \n";
        msg = msg + "=========== \n";
        for(Simulation x : simulationsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of simulations
    public static String displayDetailedSimulationsList(ArrayList<Simulation> simulationsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Simulations \n";
        msg = msg + "=========== \n";
        for(Simulation x : simulationsList){
            count++;
            msg = msg + "" + count + ")" + displaySimulation(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of simulations
    public static String displayExtraDetailedSimulationsList(ArrayList<Simulation> simulationsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Simulations \n";
        msg = msg + "=========== \n";
        for(Simulation x : simulationsList){
            count++;
            msg = msg + "" + count + ")" + displayDetailedSimulation(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of outputs
    public static String displayOutputsList(ArrayList<Output> outputsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Output x : outputsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of outputs
    public static String displayDetailedOutputsList(ArrayList<Output> outputsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Output x : outputsList){
            count++;
            msg = msg + "" + count + ")" + displayOutput(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


    //displays the contents of an ArrayList of outputs
    public static String displayExtraDetailedOutputsList(ArrayList<Output> outputsList){
        String msg= "";
        int count = 0;
        //msg = msg + " \n";
        msg = msg + "Products \n";
        msg = msg + "======== \n";
        for(Output x : outputsList){
            count++;
            msg = msg + "" + count + ")" + displayDetailedOutput(x) + "\n";
        }
        //msg = msg + " \n";
        return msg;
    }


}
