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

    @Query("select distinct rc from RankExercise re, Evaluation ev join ev.exercises ex join ev.groups g join g.members m " +
            "join re.rankCriterias rc where ev.id = :evaluationId and re.rank.id = m.rank.id and re.exercise.id = ex.id order by rc.id")
    public List<RankCriteria> findByEvaluationId(@Param("evaluationId") Long evaluationId);
}
