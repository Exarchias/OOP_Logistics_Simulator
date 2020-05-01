package sample;

public class RTools {
    //Robert: This is the place where static methods that are used in many places are located

    //This method helps with the transition from one page to another.
    //but if the user is not logged in he gets kicked to login page
    public static void goToScene(String theSceneName) throws Exception {
        if(DataHolder.isLoggedIn()){
            Main.getInstance().setScene(theSceneName); //this little line does the transition to the other scene.
        } else {
            Main.getInstance().setScene("sample"); //this little line does the transition to the other scene.
        }
    }

    //This method does the logout in a specific way.
    public static void logout() throws Exception {
        DataHolder.setLoggedIn(false);
        Main.getInstance().setScene("sample"); //this little line does the transition to the other scene.
    }

    //This method takes the user to the dashboard.
    //but if the user is not logged in he gets kicked to login page
    public static void goToDashBoard() throws Exception {
        if(DataHolder.isLoggedIn()){
            Main.getInstance().setScene("dashboard"); //this little line does the transition to the other scene.
        } else {
            Main.getInstance().setScene("sample"); //this little line does the transition to the other scene.
        }
    }

    //this method kicks the user if he is not logged in.
    public static void kickIfNotLoggedIn(){
        if(!DataHolder.isLoggedIn()){
            try {
                RTools.goToScene("sample");
                System.out.println("you are kicked because you are not logged in");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //This method is added to the main. is like the initialization but for the applacation.
    //please don't modify its content without asking me, (I am Robert)
    public static void startScript(){
        createASimualtion("The very first simulation");
        Person person = new Person("Mock Person");
        Product product = new Product("A product", 1);
        DataHolder.personInFocus = person;
        DataHolder.productInFocus = product;
        DataHolder.personInFocus.products.add(product);
        DataHolder.simulationInFocus.population.add(person);
    }

    //This method creates a Simulation()
    public static void createASimualtion(String nameOfSimulation){
        Simulation sim = new Simulation(nameOfSimulation);
        DataHolder.simulations.add(sim);
        DataHolder.simulationInFocus = sim;
    }

    //This method creates a new Person (for now is a mock method)
    public static void createAPerson(String nameOfPerson){
        System.out.println("A person has been created with the name " + nameOfPerson);
    }

    //This method edits a Person (for now is a mock method)
    public static void editAPerson(String nameOfPerson){
        System.out.println("A person has been edited and the new name is " + nameOfPerson);
    }

    //This method creates a new Product (for now is a mock method)
    public static void createAProduct(String titleOfProduct){
        System.out.println("A product has been created with the title " + titleOfProduct);
    }

    //This method edits a Product (for now is a mock method)
    public static void editAProduct(String titleOfProduct){
        System.out.println("A product has been edited and the new title is " + titleOfProduct);
    }
}
