package sample;

import java.util.ArrayList;

public class Display {

    //The main architecture for every method

    public static String nameOfMethod(Object objectsName){
        String msg= "";
        //do some code with the object objectsName
        return msg;
    }




    //For displaying the details of a person
    public static String displayPerson(Person person){
        String msg= "";
        msg = "Name: " + person.getName();
        return msg;
    }




    public static String displayProductsList(ArrayList<Product> productsList){
        String msg= "";
        int count = 0;
        msg = msg + "Products of the person \n";
        msg = msg + "====================== \n";
        for(Product x : productsList){
            count++;
            msg = msg + "" + count + ")" + x.getTitle() + "\n";
        }
        return msg;
    }


}
