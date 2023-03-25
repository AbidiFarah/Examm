package agena.sft.com.example.exam.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    private Integer idSprint;
    private String descriptionSprint ;

    private Date startDate;
    @ManyToOne
    private Project projectSprint;


}
