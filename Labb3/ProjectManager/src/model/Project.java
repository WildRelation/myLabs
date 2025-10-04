package model;

import model.matcher.ITaskMatcher;
import model.matcher.PrioMatcher;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;


public class Project implements Comparable<Project>, Serializable {
    private String title;
    private final int id;
    private final String description;
    private final LocalDateTime created;
    private int nextTaskId;
    private final ArrayList<Task> tasks;

    Project(String title, String description, int id){
        this.title = title;
        this.description = description;
        this.id = id;
        nextTaskId = 0;
        tasks = new ArrayList<>();
        created = LocalDateTime.now();
    }

    public Task addTask(String description, Prio prio){
        Task newTask = new Task(description, prio, nextTaskId);
        tasks.add(newTask);
        nextTaskId++;
        return newTask;
    }

    public ArrayList<Task> findTasks(ITaskMatcher matcher){
        ArrayList<Task> result = new ArrayList<>();

        for(Task task : tasks){
            if(matcher.match(task)){
                result.add(task);
            }
        }
        return result;
    }

    public boolean removeTask(Task task){
        return tasks.remove(task);
    }

    //ArrayList<Task> prioResult = findTasks(new PrioMatcher(Prio.High));

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Måste kolla om implemetationer på interfacet
    public ProjectState getProjectState(){
        if(tasks.isEmpty()) return ProjectState.EMPTY;
        int n = 0;
        for(Task task: tasks){
            if (task.getState()==TaskState.DONE) n++;
        }
        if(n==tasks.size()) return ProjectState.COMPLETED;
        return ProjectState.ONGOING;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getLastUpdated(){
        ArrayList<LocalDateTime> times = new ArrayList<>();
        for(Task task: tasks){
            times.add(task.getLastUpdate());
        }
        return Collections.max(times);
    }

    public Task getTaskById(int id){
        for(Task task: tasks){
            if(task.getId()==id) return task;
        }
        return null;
    }

    public int getNextTaskId() {
        return nextTaskId;
    }

    @Override

    //fråga lärare
    public int compareTo(Project project){
        return this.title.compareTo(project.title);
    }

    @Override
    public String toString() {
        return "Project Id: " + id + "',\n" +
                "  title = '" + title + "',\n" +
                "  description = '" + description + "',\n" +
                "  created = " + created + ",\n" +
                "  nextTaskId = " + nextTaskId + ",\n" +
                "  tasks = " + tasks.size() + "\n";
    }


}

