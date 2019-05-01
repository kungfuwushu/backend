package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.test.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long>{
    @Query("select t from TestResult t where t.test.id = :testId")
    public List<TestResult> findAllByTestId(@Param("testId") Long testId);

    @Query("select t from TestResult t where t.performer.id = :performerId")
    public List<TestResult> findAllByPerformerId(@Param("performerId") Long performerId);

    @Query("select CASE WHEN count(t)> 0 THEN true ELSE false END from TestResult t where t.test.id = :testId and t.performer.id = :performerId")
    public boolean existsWithTestIdAndPerformerId(@Param("testId") Long testId, @Param("performerId") Long performerId);
}
