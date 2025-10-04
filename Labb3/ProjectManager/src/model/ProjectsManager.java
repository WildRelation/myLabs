package model;

import java.util.ArrayList;
import java.util.Objects;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projects;

    public ProjectsManager(){
        projects = new ArrayList<>();
        nextProjectId = 0;
    }
    public void setProjects(ArrayList<Project> incomingProjects) {
        projects.clear();
        projects.addAll(incomingProjects);
        nextProjectId = getHighestId()+1;
    }

    public Project addProject(String title, String description) throws TitleNotUniqueException{

        if(!isTitleUnique(title)) throw new TitleNotUniqueException("Not unique title") ;
        projects.add(new Project(title, description, nextProjectId));
        nextProjectId++;
        return projects.getLast();
    }

    public boolean isTitleUnique(String title){
        for (Project project : projects) {
            if (Objects.equals(project.getTitle(), title)) return false;
        }
        return true;
    }

    public void projectState(int id){
        Project project = getProjectById(id);
        ProjectState projectState = project.getProjectState();
        if (projectState==ProjectState.EMPTY) {
            System.out.println("Empty");
        }
        else if (projectState== ProjectState.ONGOING) {
            System.out.println("Ongoing");
        } else if (projectState==ProjectState.COMPLETED) {
            System.out.println("Completed");
        }
    }

    public void removeProject(Project project){
        if(!projects.remove(project)) System.out.println("Invalid id");
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }


    public Project getProjectById(int id){
        for (int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getId()==id) return projects.get(i);
        }
        return null;
    }
    public ArrayList<Project> findProjects(String titleStr){
        ArrayList<Project> result = new ArrayList<>();
        for(Project project:projects){
            if(project.getTitle().equals(titleStr)){
                result.add(project);
            }
        }
        return result;
    }


    private int getHighestId(){
        return projects.getLast().getId();
    }

    @Override
    public String toString() {
        return "projects = " + projects;
    }
}