package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.exercise.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
}
