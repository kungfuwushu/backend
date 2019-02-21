package fr.kungfunantes.backend.model.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
    public List<Group> findByNameContaining(String name);

    @Query("select e.groups from Evaluation e where e.id = :evaluationId")
    public List<Group> findByEvaluationId(@Param("evaluationId") Long evaluationId);
}
