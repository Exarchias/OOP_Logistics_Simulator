package sample;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DataHolder {
    private static boolean LoggedIn = false;
    public static Person personInFocus;
    public static Product productInFocus;
    public static Simulation simulationInFocus;
    public static ArrayList<Simulation> simulations = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Person> persons = new ArrayList<>();
    public static ArrayList<Output> outputs = new ArrayList<>();


    static Account activeUser;
    static boolean isAdmin;
    static Account userInFocus;

    static ArrayList<Account> arrayAllUsers; //users as a normal Arraylist
    static {
        try {
            arrayAllUsers = userPopulate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    static ArrayList<Account> userPopulate() throws NoSuchAlgorithmException {
        ArrayList<Account> tempAr = new ArrayList<>();
        Account tmpUser = new Account("Abdul@gmail.com", "admin", "199412046253");
        tmpUser.setEmail("Abdul@gmail.com");
        tmpUser.setMember_SSN("199412046253");
        tempAr.add(tmpUser);

        return tempAr;
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
