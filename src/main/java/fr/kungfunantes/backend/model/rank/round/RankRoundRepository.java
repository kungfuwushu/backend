package fr.kungfunantes.backend.model.rank.round;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRoundRepository extends JpaRepository<RankRound, Long> {
}
