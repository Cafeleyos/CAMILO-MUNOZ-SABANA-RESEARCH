package entities;

import java.util.ArrayList;

public class Student {
    private ArrayList<Activity> assignedActivities;
    private String name;
    private int code;
    private String lastName;
    private String email;

    public Student(String name, String lastName,int code,ArrayList<Activity> assignedActivities) {
        this.assignedActivities = assignedActivities;
        this.name = name;
        this.lastName = lastName;

    }
    public Student(String name, String lastName,int code) {
        this.assignedActivities = new ArrayList<>();
        this.name = name;
        this.lastName = lastName;

    }
    public void addActivities (ArrayList<Activity> activities){
        assignedActivities.addAll(activities);
    }

    public ArrayList<Activity> getAssignedActivities() {
        return assignedActivities;
    }
    public String getName() {
        return name;
    }
}
