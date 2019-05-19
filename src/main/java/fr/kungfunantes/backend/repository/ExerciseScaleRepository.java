package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExerciseScaleRepository extends JpaRepository<ExerciseScale, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update ExerciseScale e set e.newestVersion.id =:newId where e.newestVersion.id =:previousId")
    public void updateNewestVersionId(@Param("previousId") Long previousId, @Param("newId") Long newId);
}