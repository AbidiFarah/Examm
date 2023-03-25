package agena.sft.com.example.exam.Repository;

import agena.sft.com.example.exam.Entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorySprint extends JpaRepository<Sprint,Integer> {
  @Query("select count(s) from Sprint s where s.projectSprint = ?1")
  Integer  countSprintsByProjectSprint(Integer idProject);
}
