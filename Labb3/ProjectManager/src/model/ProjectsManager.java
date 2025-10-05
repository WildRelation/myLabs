package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projects;

    /**
     * Manages a collection of {@link Project} objects.
     * Handles creation, retrieval, and removal of projects,
     * ensuring unique titles and continuous ID assignment.
     *
     * @author Joseph
     * @author Mahdi
     */
    public ProjectsManager(){
        projects = new ArrayList<>();
        nextProjectId = 0;
    }

    /**
     * Replaces all current projects with the given list.
     * @param incomingProjects list of existing projects
     */
    public void setProjects(ArrayList<Project> incomingProjects) {
        projects.clear();
        projects.addAll(incomingProjects);
        nextProjectId = getHighestId()+1;
    }

    /**
     * Adds a new project with a unique title.
     * @param title project title
     * @param description short project description
     * @return the created project
     * @throws TitleNotUniqueException if the title already exists
     */
    public Project addProject(String title, String description) throws TitleNotUniqueException{

        if(!isTitleUnique(title)) throw new TitleNotUniqueException("Not unique title") ;
        projects.add(new Project(title, description, nextProjectId));
        nextProjectId++;
        return projects.getLast();
    }

    /**
     * Checks if a title is unique among all projects.
     * @param title the title to check
     * @return true if unique, false otherwise
     */
    public boolean isTitleUnique(String title){
        for (Project project : projects) {
            if (Objects.equals(project.getTitle(), title)) return false;
        }
        return true;
    }

    /**
     * Prints the current state of a project by its ID.
     * @param id project ID
     */
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

    /**
     * Removes a project from the list.
     * @param project project to remove
     */
    public void removeProject(Project project){
        if(!projects.remove(project)) System.out.println("Invalid id");
    }

    /**
     * Returns all projects managed by this instance.
     *
     * @return list of projects
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }


    /**
     * Finds a project by its ID.
     *
     * @param id ID of the project
     * @return the matching project, or {@code null} if not found
     */
    public Project getProjectById(int id){
        for (int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getId()==id) return projects.get(i);
        }
        return null;
    }


    /**
     * Sorts all projects alphabetically by title.
     */
    public void sortProjectsByName(){
        Collections.sort(projects);
    }

    /**
     * Finds projects with the given title.
     * @param titleStr project title
     * @return list of matching projects
     */
    public ArrayList<Project> findProjects(String titleStr){
        ArrayList<Project> result = new ArrayList<>();
        for(Project project:projects){
            if(project.getTitle().equals(titleStr)){
                result.add(project);
            }
        }
        return result;
    }

    /**
     * Prints all projects with their ID, title, and state.
     * If there are no projects, a message is shown instead.
     */
    public void showAllProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }

        System.out.println("--- All Projects ---");
        for (Project p : projects) {
            System.out.printf("ID: %d | Title: %s | State: %s%n",
                    p.getId(),
                    p.getTitle(),
                    p.getProjectState());
        }
        System.out.println("--------------------");
    }


    /** @return the highest project ID currently used */
    private int getHighestId(){
        return projects.getLast().getId();
    }

    @Override
    public String toString() {
        return "projects = " + projects;
    }
}