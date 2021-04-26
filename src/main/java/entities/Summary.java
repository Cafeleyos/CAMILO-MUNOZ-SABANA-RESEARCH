package entities;

import java.time.LocalDate;

public class Summary {

    private int activeProjects;
    private LocalDate date;
    private int closedProjects;

    public Summary(LocalDate currentDate, int proyects,int closedProjects) {
        this.date = currentDate;
        this.activeProjects = proyects;
        this.closedProjects =closedProjects;
    }

    public int getActiveProjects() {
        return activeProjects;
    }

    public int getClosedProjects(){
        return closedProjects;
    }

    public LocalDate getDate() {
        return date;
    }
}
