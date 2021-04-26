package entities;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends Activity {

    private List<Step> steps;
    private Duration duration;
    private String state;

    public NormalActivity(String name, String state, Iteration iteration) {
        super(name, state, iteration);
        this.steps = new ArrayList<>();
        this.state = state;
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

    @Override
    public Duration getDuration() throws SabanaResearchException {
        if (steps.isEmpty()){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_NORMAL_ACTIVITY);
        }
        Duration duration = Duration.ZERO;
        for(Step s: steps){
            if (stateValidation(ACTIVE_STATE))
            duration = duration.plus(s.getDuration());
        }
        return duration;
    }

    public boolean stateValidation(String state) {
        boolean result = false;
        if (state.equals(Activity.ACTIVE_STATE)) {
            if (this.state.equals("active")) {
                result = true;
            }
            if (this.state.equals("pending")) {
                result = true;
            }
        }
        if (state.equals(Activity.CLOSED_STATE)) {
            result = true;
        }

        return result;
    }

}
