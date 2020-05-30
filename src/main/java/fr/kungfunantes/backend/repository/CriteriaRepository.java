package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.criteria.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CriteriaRepository extends JpaRepository<Criteria, Long>{
  @Modifying
  @Query("delete from Criteria where id = :idDelete")
  public void deleteById(@Param("idDelete") Long idDelete);

  Optional<Criteria> findById(Long id);
}
