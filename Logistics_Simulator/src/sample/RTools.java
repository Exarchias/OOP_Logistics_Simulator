package sample;

public class RTools {
    //Robert: This is the place where static methods that are used in many places are located

    //This method helps with the transition from one page to another.
    //but if the user is not logged in he gets kicked to login page
    public static void goToScene(String theSceneName) throws Exception {
        if (DataHolder.isLoggedIn()) {
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
        if (DataHolder.isLoggedIn()) {
            Main.getInstance().setScene("dashboard"); //this little line does the transition to the other scene.
        } else {
            Main.getInstance().setScene("sample"); //this little line does the transition to the other scene.
        }
    }

    //this method kicks the user if he is not logged in.
    public static void kickIfNotLoggedIn() {
        if (!DataHolder.isLoggedIn()) {
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
    public static void startScript() {
        createASimualtion("The very first simulation");
        Person person = new Person("Mock Person");
        Product product = new Product("A product", 1);
        DataHolder.personInFocus = person;
        DataHolder.productInFocus = product;
        DataHolder.personInFocus.products.add(product);
        DataHolder.simulationInFocus.population.add(person);
    }

    //This method creates a Simulation()
    public static void createASimualtion(String nameOfSimulation) {
        Simulation sim = new Simulation(nameOfSimulation);
        DataHolder.simulations.add(sim);
        DataHolder.simulationInFocus = sim;
        System.out.println("This simulation has been created: " + nameOfSimulation);
    }

    //This method creates a new Person (for now is a mock method)
    public static void createAPerson(String nameOfPerson) {
        //Person person = new Person(nameOfPerson);
        DataHolder.personInFocus.setName(nameOfPerson);
        System.out.println("A person has been created with the name " + nameOfPerson);
    }

    //This method edits a Person (for now is a mock method)
    public static void editAPerson(String nameOfPerson) {
       String previousName = DataHolder.personInFocus.getName();

        String tmpName = previousName;

        previousName = nameOfPerson;

        nameOfPerson = previousName;

        DataHolder.personInFocus.setName(nameOfPerson);
        System.out.println("A person with this name: " + tmpName +" has been edited and the new name is " + nameOfPerson);
        System.out.println("The saved name of person is " + DataHolder.personInFocus.getName());
    }

    //This method creates a new Product (for now is a mock method)
    public static void createAProduct(String titleOfProduct) {
        DataHolder.productInFocus.setTitle(titleOfProduct);
        System.out.println("A product has been created with the title " + titleOfProduct);
    }

    //This method edits a Product (for now is a mock method)
    public static void editAProduct(String titleOfProduct) {
        String previousTitleOfProduct = DataHolder.productInFocus.getTitle();
        String tmpTitle = previousTitleOfProduct;
        previousTitleOfProduct = titleOfProduct;
        titleOfProduct = previousTitleOfProduct;
        DataHolder.productInFocus.setTitle(titleOfProduct);
        System.out.println("A product with this title: "+tmpTitle + " has been edited and the new title is " + titleOfProduct);
        System.out.println("The saved title of product is " + titleOfProduct);
    }
    //MOCK METHOD
    public static void editASimulation(String titleOfSimulation){
        String previousTitleOfSimulation = DataHolder.simulationInFocus.getTitle();
        String tmpSimulationTitle = previousTitleOfSimulation;
        previousTitleOfSimulation = titleOfSimulation;
       titleOfSimulation = previousTitleOfSimulation;
        DataHolder.simulationInFocus.setTitle(titleOfSimulation);
        System.out.println("A simulation with this name " + tmpSimulationTitle + " has been edited and the new title is " + titleOfSimulation);
        System.out.println("the saved title of simulation is "+ titleOfSimulation);

    }
}
