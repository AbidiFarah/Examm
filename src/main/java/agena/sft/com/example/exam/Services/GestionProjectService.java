package agena.sft.com.example.exam.Services;


import agena.sft.com.example.exam.Entity.Project;
import agena.sft.com.example.exam.Entity.Role;
import agena.sft.com.example.exam.Entity.Sprint;
import agena.sft.com.example.exam.Entity.User;
import agena.sft.com.example.exam.Repository.RepositoryProject;
import agena.sft.com.example.exam.Repository.RepositorySprint;
import agena.sft.com.example.exam.Repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GestionProjectService implements IGestionProjectService
{

    private final RepositoryProject repositoryProject ;
    private final RepositoryUser repositoryUser;
    private final RepositorySprint repositorySprint ;
    @Override
    public Project addProject(Project project) {
        //without cascade
        /*/Assert.isNull(project,"The project  is null ");
        List<Sprint> sprints = project.getSprints();
        Assert.isNull(sprints,"The project  is null ");

        for(Sprint sprint : sprints)
        {
            repositorySprint.saveAndFlush(sprint);
            sprint.setProjectSprint(project);
        }
        return  repositoryProject.save(project);*/

        // with cascade
        if(project.getSprints() != null){
            repositoryProject.saveAndFlush(project) ;//manger entity he have a refence in data base
            project.getSprints().forEach(sprint -> sprint.setProjectSprint(project));

        }
        return repositoryProject.save(project);

    }

    @Override
    public User addUser(User user) {
        return repositoryUser.save(user);
    }
    @Transactional
    @Override
    public void assingProjectToUser(int idProject, int idUser) {

        Project project  = repositoryProject.findById(idProject).orElse(null);
        User user = repositoryUser.findById(idUser).orElse(null);
        System.out.println(project.getIdProject());
        System.out.println(user.getIdUser());
        Assert.notNull(project,"this project is null");
        Assert.notNull(user,"this user is null");
        List<Project> projetList = new ArrayList<>();
        projetList.add(project);
        user.setProjects(projetList);
    }
    @Transactional
    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Project project = repositoryProject.findById(projectId).orElse(null);
        User user = repositoryUser.findByFNameAndLNameAndRole(firstName,lastName, Role.CLIENT);

        Assert.isNull(project,"this project is null");
        Assert.isNull(user,"this user is null");

        user.getProjects().add(project);
        repositoryUser.saveAndFlush(user);
    }

    @Override
    public List<Project> getAllCurrentProject() {
        return repositoryProject.findAllBySprintsStartDateAfter();
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User user = repositoryUser.findByFNameAndLNameAndRole(fName,lName , Role.SCRUM_MASTER);
        Assert.isNull(user,"this user is null");
        return user.getProjectsUser();

    }
    @Transactional
    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = repositoryProject.findById(idProject).orElse(null);
        Assert.isNull(project,"this project is null");
        Assert.isNull(sprint,"this sprint is null");

        repositorySprint.saveAndFlush(sprint);
        project.getSprints().add(sprint);

    }
    @Scheduled(cron = "*/30 * * * * *")
    @Override
    public void getNbrSprintByCurrentProject() {
      this.getAllCurrentProject()
              .forEach(project -> {
                    Integer nbrSprint = repositorySprint.countSprintsByProjectSprint(project.getIdProject());
                    System.out.println("the project " + project.getIdProject() +" "+ project.getTitle()+ "have "+ nbrSprint +" Sprints");
                });

    }
}
