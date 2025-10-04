package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Comparable<Task>, Serializable{
    private final String description;
    private final int id;
    private String takenBy;
    private TaskState state;
    private LocalDateTime lastUpdate;
    private Prio prio;

    Task(String description, Prio prio, int id){
        this.description = description;
        this.prio = prio;
        this.id = id;
        this.takenBy = null;
        lastUpdate = LocalDateTime.now();
    }

    public void setTakenBy(String takenBy) {
        if(this.takenBy!=null) throw new IllegalStateException("This task taken by another person already");
        this.takenBy = takenBy;
        setLastUpdate();
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(){
        this.lastUpdate = LocalDateTime.now();
    }

    public void setState(TaskState state) {
        this.state = state;
        setLastUpdate();
    }

    public void setPrio(Prio prio) {
        this.prio = prio;
        setLastUpdate();
    }

    public String getTakenBy() {
        return takenBy;
    }

    public Prio getPrio() {
        return prio;
    }

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


    public int getId() {
        return id;
    }

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