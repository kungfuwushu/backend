package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{
}
