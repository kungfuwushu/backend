package fr.kungfunantes.backend.model.rank.criteria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankCriteriaRepository extends JpaRepository<RankCriteria, Long>{
    @Query("select c from RankCriteria c where c.rankExercise.id = :rankExerciseId")
    public List<RankCriteria> findByRankExerciseId(@Param("rankExerciseId") Long rankExerciseId);
}
