package model.matcher;

import model.Task;
import model.TaskState;

public class AllTasksMatcher implements ITaskMatcher {

    private Task task;

    @Override
    public boolean match(Task task){
         return task!=null ;
    }

}