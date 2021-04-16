package entities;

import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends Activity {

    private List<Step> steps;
    private Duration duration;
    public NormalActivity(String name, String state, Iteration iteration) {
        super(name, state, iteration);
        this.steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

    @Override
    public Duration getDuration() throws SabanaResearchException {
        if (steps.size()==0){
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_NORMAL_ACTIVITY);
        }
        Duration duration = Duration.ofDays(0);
        for(Step s: steps){
            if (super.isActive())
            duration = duration.plusDays(s.getDuration().toDays());
        }
        return duration;
    }
}
