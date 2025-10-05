package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents a task within a project.
 * Each task has a unique ID, a description, a priority level,
 * an optional assignee, and a timestamp indicating the last update.
 *
 * <p>This class implements {@link Comparable} to allow tasks
 * to be sorted by priority and description.</p>
 *
 * @author Joseph
 * @author Mahdi
 */
public class Task implements Comparable<Task>, Serializable{
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDateTime lastUpdate;
    private Prio prio;

    /**
     * Creates a new task with the given description, priority, and unique ID.
     * The task is initially unassigned and its last update time is set to the current time.
     *
     * @param description a short text describing the task
     * @param prio the priority level of the task
     * @param id the unique identifier for this task
     */

    Task(String description, Prio prio, int id){
        this.description = description;
        this.prio = prio;
        this.id = id;
        this.takenBy = null;
        lastUpdate = LocalDateTime.now();
    }

    /**
     * Assigns the task to a person.
     * If the task is already taken, an exception is thrown.
     *
     * @param takenBy the name of the person taking the task
     * @throws IllegalStateException if the task is already assigned
     */

    public void setTakenBy(String takenBy) {
        if(this.takenBy!=null) throw new IllegalStateException("This task taken by another person already");
        this.takenBy = takenBy;
        setLastUpdate();
    }

    /**
     * Returns the date and time when this task was last updated.
     *
     * @return the last update timestamp
     */
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Updates the {@code lastUpdate} field to the current date and time.
     */
    public void setLastUpdate(){
        this.lastUpdate = LocalDateTime.now();
    }

    /**
     * Sets the task’s current state and updates its last modified time.
     *
     * @param state the new state of the task
     */
    public void setState(TaskState state) {
        this.state = state;
        setLastUpdate();
    }

    /**
     * Sets a new priority level for this task and updates its last modified time.
     *
     * @param prio the new priority
     */
    public void setPrio(Prio prio) {
        this.prio = prio;
        setLastUpdate();
    }

    /**
     * Returns the name of the person assigned to this task.
     *
     * @return the assignee’s name, or {@code null} if unassigned
     */
    public String getTakenBy() {
        return takenBy;
    }

    /**
     * Returns the priority level of this task.
     *
     * @return the task’s priority
     */
    public Prio getPrio() {
        return prio;
    }


    /**
     * Compares this task with another task first by priority, then by description.
     *
     * @param task the other task to compare with
     * @return a negative number if this task should come before,
     *         zero if equal in order, or a positive number otherwise
     */

    @Override
    public int compareTo(Task task){
        //First key, prio
        int result = this.prio.compareTo(task.prio);
        if (result==0){
            // second key, description
            result = this.description.compareTo(task.description);
        }
        return result;
    }

    /**
     * Checks if this task is equal to another object.
     * Two tasks are considered equal if they share the same ID.
     *
     * @param obj the object to compare with
     * @return {@code true} if the other object is a Task with the same ID, otherwise {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task)) return false;
        Task other = (Task) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns the unique ID of this task.
     *
     * @return the task ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the current state of this task.
     *
     * @return the task’s state
     */
    public TaskState getState() {
        return state;
    }

    @Override
    public String toString() {
        return "TaskId: " + id +",\n" +
                "description = '" + description + "',\n" +
                "takenBy = '" + takenBy + "',\n" +
                "state = " + state + ",\n" +
                "lastUpdate = " + lastUpdate + ",\n" +
                "prio = " + prio + "\n";
    }


}