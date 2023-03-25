package agena.sft.com.example.exam.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    private Integer idProject;

    private  String title ;

    private String description;
    @OneToMany(mappedBy = "projectSprint" , cascade = CascadeType.ALL)
    private List<Sprint> sprints ;

    @ManyToMany(mappedBy = "projectsUser")
    @JsonIgnore
    private List<User> users;

}
