package entities;

import java.time.Duration;

public abstract class Activity {

    public static final String ACTIVE_STATE = "active";
    public static final String CLOSED_STATE = "closed";
    public static final String PENDING_STATE = "pending";
    public static final String CANCELED_STATE = "canceled";

    private String name;
    private String state;
    private Iteration iteration;


    public Activity(String name, String state, Iteration iteration) {
        this.name = name;
        this.state = state;

        if (iteration != null) {
            this.iteration = iteration;
            this.iteration.addActivity(this);
        }
    }


    /**
     * Get the duration of the activity.
     *
     * @return
     */
    public abstract Duration getDuration() throws SabanaResearchException;

    public abstract boolean stateValidation(String state);
}
