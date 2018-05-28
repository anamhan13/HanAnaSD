package repository;

import entity.PersonStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<PersonStatus, Long> {

    PersonStatus findByName(String name);
}
