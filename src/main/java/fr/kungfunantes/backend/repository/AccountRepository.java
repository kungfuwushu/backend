package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Optional<Account> findByEmail(String email);

    List<Account> findByIdIn(List<Long> userIds);

    Optional<Account> findById(Long id);

    Boolean existsByEmail(String email);
}
