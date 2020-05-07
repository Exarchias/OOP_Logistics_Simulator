package sample;

import java.util.ArrayList;

public class Output {
    private String title = "an output";
    public ArrayList<Person> persons = new ArrayList<>();

    public Output(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
