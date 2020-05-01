package sample;

import java.util.ArrayList;

public class DataHolder {
    private static boolean LoggedIn = false;
    public static Person personInFocus;
    public static Product productInFocus;
    public static Simulation simulationInFocus;
    public static ArrayList<Simulation> simulations = new ArrayList<>();

    public static boolean isLoggedIn() {
        return LoggedIn;
    }

    public static void setLoggedIn(boolean isLoggedIn) {
        DataHolder.LoggedIn = isLoggedIn;
    }
}
