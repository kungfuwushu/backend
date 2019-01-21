package fr.kungfunantes.backend.model.result.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseResultRepository extends JpaRepository<ExerciseResult, Long>{
    @Query("select e from ExerciseResult e where e.evaluationResult.id = :evaluationResultId")
    public List<ExerciseResult> findByEvaluationResultId(@Param("evaluationResultId") Long evaluationResultId);
}
