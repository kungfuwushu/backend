package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
    @Query("select t.groups from Test t where t.id = :testId")
    public List<Group> findByTestId(@Param("testId") Long testId);
}
