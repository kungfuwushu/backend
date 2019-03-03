package fr.kungfunantes.backend.model.result.round;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundResultRepository extends JpaRepository<RoundResult, Long> {
}
