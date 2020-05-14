package sample;

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
        return true;
    }

    public static boolean task12 (){
        return true;
    }

    public static boolean task13 (){
        return true;
    }

    public static boolean task14 (){
        return true;
    }

    public static boolean task15 (){
        return true;
    }

    public static boolean task16 (){
        return true;
    }

    public static boolean task17 (){
        return true;
    }

    public static boolean task18 (){
        return true;
    }

    public static boolean task19 (){
        return true;
    }

}
