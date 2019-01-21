package fr.kungfunantes.backend.model.rank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends JpaRepository<Rank, Long>{
    public List<Rank> findByName(String name);
}
