package fr.kungfunantes.backend.model.member;

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

    @Query("select m from Member m, Evaluation e where e.id = :evaluationId and m.group.id in e.groups")
    public List<Member> findByEvaluationId(@Param("evaluationId") Long evaluationId);
}
