package entities;

import java.time.Duration;
import java.util.HashMap;

public class ExecutiveSynthesizer implements ISynthesizer {

    public HashMap<String, Duration> synthesize(Project p) throws SabanaResearchException {
       HashMap<String, Duration> result = new HashMap<>();
        for (Iteration i : p.getIterations()) {
            result.put(i.getGoal(),i.getDuration());
        }
        return result;
    }
}
