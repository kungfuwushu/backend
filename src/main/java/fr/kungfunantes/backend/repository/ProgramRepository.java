package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>{
    @Query("select p from Program p where type(p) = 'PROGRAM'")
    public List<Program> findAll();
}
