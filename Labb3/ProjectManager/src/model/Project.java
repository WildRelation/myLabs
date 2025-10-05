package model;

import model.matcher.ITaskMatcher;
import model.matcher.PrioMatcher;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a project containing multiple tasks.
 * Each project has a title, description, creation date, and a list of tasks.
 *
 * @author Joseph
 * @author Mahdi
 */
public class Project implements Comparable<Project>, Serializable {
    private String title;
    private final int id;
    private final String description;
    private final LocalDateTime created;
    private int nextTaskId;
    private final ArrayList<Task> tasks;


    /**
     * Creates a new project.
     * @param title project title
     * @param description short project description
     * @param id unique project ID
     */
    Project(String title, String description, int id){
        this.title = title;
        this.description = description;
        this.id = id;
        nextTaskId = 0;
        tasks = new ArrayList<>();
        created = LocalDateTime.now();
    }

    /**
     * Adds a new task to the project.
     * @param description description of the task
     * @param prio priority level of the task
     * @return the created task
     */
    public Task addTask(String description, Prio prio){
        Task newTask = new Task(description, prio, nextTaskId);
        tasks.add(newTask);
        nextTaskId++;
        return newTask;
    }

    /**
     * Finds all tasks matching a given condition.
     * @param matcher object defining the matching rule
     * @return list of matching tasks
     */
    public ArrayList<Task> findTasks(ITaskMatcher matcher){
        ArrayList<Task> result = new ArrayList<>();

        for(Task task : tasks){
            if(matcher.match(task)){
                result.add(task);
            }
        }
        return result;
    }

    /**
     * Removes a task from the project.
     * @param task the task to remove
     * @return true if the task was removed, false otherwise
     */

    public boolean removeTask(Task task){
        return tasks.remove(task);
    }

    /**
     * Returns the title of the project.
     *
     * @return the project title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Updates the title of the project.
     *
     * @param title new title for the project
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return current project state based on task progress */
    public ProjectState getProjectState(){
        if(tasks.isEmpty()) return ProjectState.EMPTY;
        int n = 0;
        for(Task task: tasks){
            if (task.getState()==TaskState.DONE) n++;
        }
        if(n==tasks.size()) return ProjectState.COMPLETED;
        return ProjectState.ONGOING;
    }

    /**
     * Returns the unique ID of this project.
     *
     * @return project ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the most recent update timestamp among all tasks.
     * If no tasks exist, this method may throw an exception.
     *
     * @return the latest update time from all tasks
     */
    public LocalDateTime getLastUpdated(){
        ArrayList<LocalDateTime> times = new ArrayList<>();
        for(Task task: tasks){
            times.add(task.getLastUpdate());
        }
        return Collections.max(times);
    }

    /**
     * Sorts the project's tasks by their priority (ascending order).
     */
    public void sortTasksByPrio() {
        tasks.sort((t1, t2) -> t1.getPrio().compareTo(t2.getPrio()));
    }

    /**
     * Finds a task by its unique ID within the project.
     *
     * @param id the ID of the task
     * @return the matching task, or {@code null} if not found
     */
    public Task getTaskById(int id){
        for(Task task: tasks){
            if(task.getId()==id) return task;
        }
        return null;
    }

    /**
     * Returns the ID that will be assigned to the next created task.
     *
     * @return next available task ID
     */
    public int getNextTaskId() {
        return nextTaskId;
    }

    /**
     * Compares projects alphabetically by title.
     * @param project the project to compare with
     * @return comparison result
     */
    @Override
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

