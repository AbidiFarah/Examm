package agena.sft.com.example.exam.Repository;

import agena.sft.com.example.exam.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryProject  extends JpaRepository<Project,Integer> {

  @Query("select p from Project p inner join p.sprints sprints where sprints.startDate > Now()")
  List<Project> findAllBySprintsStartDateAfter();


}
