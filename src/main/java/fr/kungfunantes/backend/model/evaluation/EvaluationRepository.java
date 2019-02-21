package fr.kungfunantes.backend.model.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{
    @Query("select e from Evaluation e join e.groups g where e.date > CURRENT_DATE and g.id = :groupId")
    public List<Evaluation> upcomingByGroupId(@Param("groupId") Long groupId);

    @Query("select e from Evaluation e join e.groups g where e.date < CURRENT_DATE and g.id = :groupId")
    public List<Evaluation> pastByGroupId(@Param("groupId") Long groupId);
}
