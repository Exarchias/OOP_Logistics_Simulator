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
    public static ArrayList<Simulation> simulations = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Person> persons = new ArrayList<>();
    public static ArrayList<Output> outputs = new ArrayList<>();
    static ArrayList<Account> arrayAllUsers; //users as a normal Arraylist
    static Account activeUser; //we leaving it in for reasons of generalization
    static Account userInFocus; //we leaving it in for reasons of generalization
    //static boolean isAdmin; //We will not have Admin in this structure.


    static {
        try {
            arrayAllUsers = userPopulate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    static ArrayList<Account> userPopulate() throws NoSuchAlgorithmException {
        ArrayList<Account> tempAr = new ArrayList<>();
        Account tmpUser = new Account("admin", "12345");
        //tmpUser.setEmail("Abdul@gmail.com");
        tempAr.add(tmpUser);

        return tempAr;
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
