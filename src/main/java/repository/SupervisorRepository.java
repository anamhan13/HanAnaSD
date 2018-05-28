package repository;

import entity.Role;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupervisorRepository extends JpaRepository<User, Long> {

    public List<User> findByRole(Role role);

    public User findByUsername(String username);

}
