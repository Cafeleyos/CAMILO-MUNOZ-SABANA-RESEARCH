package entities;

import java.time.Duration;
import java.util.HashMap;

public class StudentSynthesizer implements ISynthesizer {
        public HashMap<String, Duration> synthesize(Project p) throws SabanaResearchException {
        Duration temp = Duration.ZERO;
        HashMap<String, Duration> result = new HashMap<>();

        for (Student s : p.getMembers()) {
            for (Activity a :s.getAssignedActivities()) {
                temp = temp.plus(a.getDuration());
            }
            result.put(s.getName(), temp);
            temp = Duration.ZERO;
        }
        return result;
    }




}
