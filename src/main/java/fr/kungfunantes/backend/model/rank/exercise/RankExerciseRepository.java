package fr.kungfunantes.backend.model.rank.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankExerciseRepository extends JpaRepository<RankExercise, Long>{
    @Query("select e from RankExercise e where e.rank.id = :rankId")
    public List<RankExercise> findByRankId(@Param("rankId") Long rankId);

    @Query("select distinct re from RankExercise re, Evaluation ev join ev.exercises ex join ev.groups g join g.members m " +
            "where ev.id = :evaluationId and re.rank.id = m.rank.id and re.exercise.id = ex.id")
    public List<RankExercise> findByEvaluationId(@Param("evaluationId") Long evaluationId);
}
