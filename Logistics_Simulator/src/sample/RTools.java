package sample;

public class RTools {
    //Robert: This is the place where static methods that are used in many places are located

    //This method helps with the transition from one page to another.
    public static void goToScene(String theSceneName) throws Exception {
        Main.getInstance().setScene(theSceneName); //this little line does the transition to the other scene.
    }

    //This method does the logout in a specific way.
    public static void logout() throws Exception {
        Main.getInstance().setScene("sample"); //this little line does the transition to the other scene.
    }
}
