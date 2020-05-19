package sample;

import java.util.ArrayList;

public class Simulation {
    private String title;
    private boolean researchQuestion = false;
    public ArrayList<Person>population = new ArrayList<>(); //uncomment when Person Class is created


    public Simulation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isResearchQuestion() {
        return researchQuestion;
    }

    public void setResearchQuestion(boolean researchQuestion) {
        this.researchQuestion = researchQuestion;
    }
}
