package fr.kungfunantes.backend.model.result.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationResultRepository extends JpaRepository<EvaluationResult, Long>{
    @Query("select e from EvaluationResult e where e.id = :evaluationId")
    public List<EvaluationResult> findByEvaluationId(@Param("evaluationId") Long evaluationId);

    @Query("select e from EvaluationResult e where e.performer.id = :memberId")
    public List<EvaluationResult> findByMemberId(@Param("memberId") Long memberId);
}
