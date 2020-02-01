package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Profile;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

    List<Profile> findByIdIn(List<Long> userIds);

    Optional<Profile> findByUsername(String username);

    Boolean existsByUsername(String username);

}
