package fr.kungfunantes.backend.repository;


import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseResultRepository extends JpaRepository<ExerciseResult, Long> {
    @Query("select e from TestResult t join t.exercisesResults e where t.id = :testResultId and e.exerciseScale.id = :exerciseScaleId")
    public List<ExerciseResult> findAllByTestResultIdAndExerciseScaleId(@Param("testResultId") Long testResultId, @Param("exerciseScaleId") Long exerciseScaleId);

    @Query("select e from TestResult t join t.exercisesResults e where t.performer.id = :memberId and t.rank.id = :rankId")
    public List<ExerciseResult> findAllByMemberIdAndRankId(@Param("memberId") Long memberId, @Param("rankId") Long rankId);

    @Query("select CASE WHEN count(e)> 0 THEN true ELSE false END from ExerciseResult e where e.exerciseScale.id = :exerciseScaleId")
    public boolean existsWithExerciseScaleId(@Param("exerciseScaleId") Long exerciseScaleId);
}
