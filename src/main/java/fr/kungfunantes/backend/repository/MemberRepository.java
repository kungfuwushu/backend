package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    @Query("select m from Member m where m.account.id = :accountId")
    public List<Member> findByAccountId(@Param("accountId") Long accountId);

    @Query("select m from Member m where m.group.id = :groupId")
    public List<Member> findByGroupId(@Param("groupId") Long groupId);

    @Query("select m from Member m, Test t join t.groups g where t.id = :testId and m.group.id = g.id")
    public List<Member> findByTestId(@Param("testId") Long testId);
}
