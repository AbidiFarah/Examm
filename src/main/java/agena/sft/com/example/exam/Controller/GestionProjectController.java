package agena.sft.com.example.exam.Controller;

import agena.sft.com.example.exam.Entity.Project;
import agena.sft.com.example.exam.Entity.Sprint;
import agena.sft.com.example.exam.Entity.User;
import agena.sft.com.example.exam.Services.IGestionProjectService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping()
public class GestionProjectController {
    private  final IGestionProjectService iGestionProjectService;
    @PostMapping("/Project")
    public Project addProject(@RequestBody Project project){
        return iGestionProjectService.addProject(project);
    }
    @PostMapping("/User")
    public User addUser(@RequestBody User user){
        return iGestionProjectService.addUser(user);
    }
    @PutMapping("/{idProject}/{idUser}")
    public void assignProjectToUser(@PathVariable("idProject") Integer idProject , @PathVariable("idUser") Integer idUser){
         iGestionProjectService.assingProjectToUser(idProject , idUser);
    }
    @GetMapping("/{idProject}/{firstName}/{lastName}")
    public void assignProjectToClient(@PathVariable("idProject") Integer idProject , @PathVariable("firstName") String firstName ,@PathVariable("lastName") String lastName){
        iGestionProjectService.assignProjectToClient(idProject , firstName ,lastName);
    }
    @GetMapping("/")
    public void getAllCurrentProject(){
        iGestionProjectService.getAllCurrentProject();
    }
    @PutMapping("/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint , @PathVariable("idProject") Integer idProject ){
        iGestionProjectService.addSprintAndAssignToProject(sprint ,idProject );
    }



}
