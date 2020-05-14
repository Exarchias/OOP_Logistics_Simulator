package sample;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DataHolder {

    static boolean dbActivated = true; //when we want to run with database
    static boolean isConnected = false;
    static Account testAccount;
    private static boolean LoggedIn = false;
    public static Person personInFocus;
    public static Product productInFocus;
    public static Simulation simulationInFocus;
    public static Output outputInFocus;
    public static ArrayList<Simulation> simulations = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Person> persons = new ArrayList<>();
    public static ArrayList<Output> outputs = new ArrayList<>();
    public static ArrayList<Account> arrayAllUsers = new ArrayList<>(); //the users of the system
    static Account activeUser; //we leaving it in for reasons of generalization
    static Account userInFocus; //we leaving it in for reasons of generalization
    //static boolean isAdmin; //We will not have Admin in this structure.



    //populated the array aarayAllUsers with a hardcoded users. great for offline mode.
    //also it ensures that at least one user will be always stable to the system
    //this will be called from the loader, (its default work before check for connection)
    static void userPopulate() {
        Account tmpUser = new Account("admin", "12345");
        arrayAllUsers.add(tmpUser);
        System.out.println("The default user was added with the name " + tmpUser.getUserName() + " and the password 12345");
    }

    static boolean userNameExists(String userName){

        for(Account account : arrayAllUsers){
            if(account.getUserName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
    }

    static boolean userEmailexist(String Email){

        for(Account account : arrayAllUsers){
            if(account.getEmail().equals(Email)){
                return true;
            }
        }
        return false;
    }




    public static boolean isLoggedIn() {
        return LoggedIn;
    }

    public static void setLoggedIn(boolean isLoggedIn) {
        DataHolder.LoggedIn = isLoggedIn;
    }


}
