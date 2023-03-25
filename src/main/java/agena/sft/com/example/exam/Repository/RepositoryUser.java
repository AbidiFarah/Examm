package agena.sft.com.example.exam.Repository;

import agena.sft.com.example.exam.Entity.Role;
import agena.sft.com.example.exam.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryUser extends JpaRepository<User,Integer> {
    User findByFNameAndLNameAndRole(String fname , String lName ,Role role);
}
