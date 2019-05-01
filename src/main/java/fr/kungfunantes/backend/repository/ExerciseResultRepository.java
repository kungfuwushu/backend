package fr.kungfunantes.backend.repository;


import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseResultRepository extends JpaRepository<ExerciseResult, Long> {
    @Query("select CASE WHEN count(e)> 0 THEN true ELSE false END from ExerciseResult e where e.exerciseScale.id = :exerciseScaleId")
    public boolean existsWithExerciseScaleId(@Param("exerciseScaleId") Long exerciseScaleId);
}
