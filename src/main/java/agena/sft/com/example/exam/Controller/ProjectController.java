package agena.sft.com.example.exam.Controller;

import agena.sft.com.example.exam.Entity.User;
import agena.sft.com.example.exam.Services.UserService.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class ProjectController
{
    private  final IUserService iUserService;
    @PostMapping()
    public User addUser(@RequestBody User user){
        return iUserService.addUser(user);
    }

}
