package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DocumentedActivity extends Activity {

    private NormalActivity activity;
    private List<Question> questions;

    public DocumentedActivity(String name, String state, Iteration iteration, NormalActivity activity) {
        super(name, state, iteration);
        this.activity = activity;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    @Override
    public Duration getDuration() throws SabanaResearchException {
        if (activity == null) {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY_WITHOUT_NORMAL_QUESTION);
        }
        if (questions.isEmpty()) {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY);
        }
        Duration result = Duration.ZERO;
        if (activity.stateValidation(Activity.ACTIVE_STATE)) {
            result = (activity.getDuration());

            for (Question l : questions) {
                result = result.plus(l.getDedication());
            }
        }
        return result;
    }

    public boolean stateValidation(String state) {
        return activity.stateValidation(state);
    }
}
