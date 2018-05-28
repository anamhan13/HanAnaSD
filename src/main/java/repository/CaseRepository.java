package repository;

import entity.Ccase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Ccase, Long> {
}
