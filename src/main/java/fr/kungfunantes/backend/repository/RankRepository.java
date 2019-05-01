package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long>{
    public List<Rank> findByOrderByPositionAsc();
}
