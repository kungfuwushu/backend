package fr.kungfunantes.backend.model.member;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.account.AccountRepository;
import fr.kungfunantes.backend.model.group.GroupRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MemberResource {

	@Autowired
	private MemberRepository memberRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/members/{id}")
    @ResponseBody
	public MemberDto byId(@PathVariable long id) {
        return convertToDto(RestPreconditions.checkFound(memberRepository.findById(id)));
	}

    @GetMapping("/accounts/{id}/members")
    @ResponseBody
	public List<MemberDto> byAcountId(@PathVariable long id) {
        return convertToDto(memberRepository.findByAccountId(id));
	}

    @GetMapping("/groups/{id}/members")
    @ResponseBody
	public List<MemberDto> byGroupId(@PathVariable long id) {
        return convertToDto(memberRepository.findByGroupId(id));
	}

    @GetMapping("/evaluations/{id}/members")
    @ResponseBody
	public List<MemberDto> byEvaluationId(@PathVariable long id) {
        return convertToDto(memberRepository.findByEvaluationId(id));
	}

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MemberDto create(@RequestBody MemberDto memberDto) {
        Member member = convertToEntity(memberDto);
        Preconditions.checkNotNull(member);
        return convertToDto(memberRepository.save(member));
    }
 
    @DeleteMapping("/members/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
    }

    private MemberDto convertToDto(Member member) {
        MemberDto memberDto = modelMapper.map(member, MemberDto.class);
        memberDto.setGroupId(member.getGroup().getId());
        memberDto.setAccountId(member.getAccount().getId());
        return memberDto;
    }

    private List<MemberDto> convertToDto(List<Member> members) {
        return members.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Member convertToEntity(MemberDto groupDto) throws ParseException {
        Member member = modelMapper.map(groupDto, Member.class);
        member.setGroup(
                RestPreconditions.checkFound(groupRepository.findById(groupDto.getGroupId()))
        );
        member.setAccount(
                RestPreconditions.checkFound(accountRepository.findById(groupDto.getAccountId()))
        );
        return member;
    }

}
