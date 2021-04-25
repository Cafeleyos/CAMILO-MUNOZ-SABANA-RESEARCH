package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SabanaResearch {

    private List<Group> groups;
    private List<Summary> summaries;
    public static final  LocalDate today = LocalDate.now();

    public SabanaResearch(List<Group> groups) {
        this.groups = groups;
        this.summaries = new ArrayList<>();
    }

    public int countOfGroups() {
        return this.groups.size();
    }

    public int countOfSummaries() {
        return this.summaries.size();
    }

    /**
     * Create a summary entry in the current date.
     * - Calculate the count of active projects.
     *
     * @return The new Summary entry.
     */
    public Summary createSummaryEntry() {
        int ap = 0;
        int at =0;
        for(Group g : groups) {
            ap += g.countProjectsState(Activity.ACTIVE_STATE);
            at += g.countProjectsState(Activity.CLOSED_STATE);
        }
        Summary newSummary = new Summary(today, ap,at);
        addSummary(newSummary);
        return newSummary;
    }
    public void addSummary(Summary s) {
        this.summaries.add(s);
    }
}
