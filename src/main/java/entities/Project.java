package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;
    private ISynthesizer synthesizer;
    private List<Student> members;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        this.members = new ArrayList<>();
        group.addProject(this);
    }

    public void addMember(Student s) {
        members.add(s);
    }
    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    public void setSynthesizer(ISynthesizer s){
        this.synthesizer = s;
    }

    public Duration getDuration() throws SabanaResearchException {
        Duration result = Duration.ZERO;
        if (this.iterations.isEmpty())
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);
        for(Iteration i: this.iterations){
            result = result.plus(i.getDuration());
        }
        return result;
    }

    public HashMap<String,Duration> summarize() throws SabanaResearchException {
        for (String key: synthesizer.synthesize(this).keySet()){
            System.out.println(key + "---" +synthesizer.synthesize(this).get(key));
        }
        return synthesizer.synthesize(this);
    }

    public List<Iteration> getIterations() {
        return iterations;
    }

    public List<Student> getMembers() {
        return members;
    }
}
