package fr.kungfunantes.backend.model.result.criteria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaResultRepository extends JpaRepository<CriteriaResult, Long>{
    @Query("select c from CriteriaResult c where c.exerciseResult.id = :exerciseResultId")
    public List<CriteriaResult> findByExerciseResultId(@Param("exerciseResultId") Long exerciseResultId);
}
