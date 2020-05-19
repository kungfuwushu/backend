package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long>{
    @Query("select distinct r from Rank r, Member m, Test t join t.groups join m.groups where t.id = :testId and m.rank.id = r.id order by r.position")
    public List<Rank> findAllByTestId(@Param("testId") Long testId);

    public List<Rank> findByOrderByPositionAsc();
}
