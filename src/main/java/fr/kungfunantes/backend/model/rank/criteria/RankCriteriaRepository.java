package fr.kungfunantes.backend.model.rank.criteria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankCriteriaRepository extends JpaRepository<RankCriteria, Long>{
}
