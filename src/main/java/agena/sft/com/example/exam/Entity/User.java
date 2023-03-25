package agena.sft.com.example.exam.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    private  Integer idUser;

    private String email ;

    private String pwd;

    private String fName;

    private String lName;

    private Role role;
    @OneToMany()
    List<Project>  projects;
    @ManyToMany()
    private List<Project> projectsUser;



}
