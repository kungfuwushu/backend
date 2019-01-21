package fr.kungfunantes.backend.model.criteria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long>{
    @Query("select c from Criteria c where c.exercise.id = :exerciseId")
    public List<Criteria> findByExerciseId(@Param("exerciseId") Long exerciseId);
}
