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

    @Query("select m from Member m where m.group.id = :groupId")
    public List<Member> findByGroupId(@Param("groupId") Long groupId);

    @Query("select m from Member m, Test t join t.groups g where t.id = :testId and m.group.id = g.id")
    public List<Member> findByTestId(@Param("testId") Long testId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Member set groupId = :groupId where id = :memberId")
    public int updateMemberGroup(@Param("memberId") Long memberId, @Param("groupId") Long groupId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Member set groupId = NULL where id = :memberId")
    public int deleteMemberGroup(@Param("memberId") Long memberId);


}
