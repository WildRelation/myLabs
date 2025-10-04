package model.matcher;

import model.Task;
import model.Prio;

public class PrioMatcher implements ITaskMatcher {
    private Prio prio;

    public PrioMatcher (Prio prio){
        this.prio = prio;
    }
    @Override
    public boolean match(Task task){
        return task.getPrio() == prio;
    }

}