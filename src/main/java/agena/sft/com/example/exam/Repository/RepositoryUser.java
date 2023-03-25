package agena.sft.com.example.exam.Repository;

import agena.sft.com.example.exam.Entity.Role;
import agena.sft.com.example.exam.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryUser extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.fName= ?1 and u.lName = ?2 and u.role = ?3")
    User findByFNameAndLNameAndRole(String fname , String lName , Role role);
}

