package fr.kungfunantes.backend.model.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
    public List<Exercise> findByNameAndType(String name, String type);
    
    @Query("select e from Exercise e where e.category.id = :categoryId")
    public List<Exercise> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query("select e.exercises from Evaluation e where e.id = :evaluationId")
    public List<Exercise> findByEvaluationId(@Param("evaluationId") Long evaluationId);
}
