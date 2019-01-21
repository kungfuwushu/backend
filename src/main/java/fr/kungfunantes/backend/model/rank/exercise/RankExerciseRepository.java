package fr.kungfunantes.backend.model.rank.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankExerciseRepository extends JpaRepository<RankExercise, Long>{
    @Query("select e from RankExercise e where e.rank.id = :rankId")
    public List<RankExercise> findByRankId(@Param("rankId") Long rankId);
}
