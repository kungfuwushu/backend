package fr.kungfunantes.backend.repository;

import fr.kungfunantes.backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

    @Query("select m from Member m, Profile p where m.profile.id = p.id and p.account.id = :accountId")
    public List<Member> findByAccountId(@Param("accountId") Long accountId);

    @Query("select m from Member m join m.groups g where g.id = :groupId")
    public List<Member> findByGroupId(@Param("groupId") Long groupId);

    @Query("select m from Member m join m.groups g join g.tests t where t.id = :testId")
    public List<Member> findByTestId(@Param("testId") Long testId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Member set groupId = NULL where id = :memberId")
    public int deleteMemberGroup(@Param("memberId") Long memberId);

}
