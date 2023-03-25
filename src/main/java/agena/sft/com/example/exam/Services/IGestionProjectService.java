package agena.sft.com.example.exam.Services;

import agena.sft.com.example.exam.Entity.Project;
import agena.sft.com.example.exam.Entity.Sprint;
import agena.sft.com.example.exam.Entity.User;

import java.util.List;

public interface IGestionProjectService
{

    public Project addProject (Project project);
    User addUser(User user);

    public void assingProjectToUser(int idProject , int idUser);

    public void assignProjectToClient(int projectId, String firstName, String lastName);

    public List<Project> getAllCurrentProject();
    public List<Project> getProjectsByScrumMaster(String fName, String lName);

    public void addSprintAndAssignToProject(Sprint sprint, int idProject);
    public void getNbrSprintByCurrentProject();





}
