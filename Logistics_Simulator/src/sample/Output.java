package sample;

import java.util.ArrayList;

public class Output {
    private String title = "an output";
    private Simulation simulation;
    public ArrayList<Person> persons = new ArrayList<>();

    public Output(String title) {
        this.title = title;
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

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
