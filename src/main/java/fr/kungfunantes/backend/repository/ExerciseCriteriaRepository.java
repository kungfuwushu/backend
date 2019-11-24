package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.model.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseCriteriaRepository extends JpaRepository<Exercise, Long>{
  @Modifying
  @Query("delete from ExerciseCriteria where exerciseId = :idDelete")
  public void deleteById(@Param("idDelete") Long idDelete);
}
