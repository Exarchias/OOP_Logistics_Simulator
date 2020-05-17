package sample;

import java.util.ArrayList;

public class Output {
    private String title = "an output";
    private Simulation simulation;
    private int days = 0;
    public ArrayList<Person> persons = new ArrayList<>();

    public Output(String title, int days) {
        this.title = title;
        this.days = days;
        this.simulation = DataHolder.simulationInFocus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
