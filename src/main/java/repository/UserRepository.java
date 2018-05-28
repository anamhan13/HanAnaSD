package repository;

import entity.Role;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    public Set<User> findByRole(Role role);

    public User findByUsername(String username);
}
