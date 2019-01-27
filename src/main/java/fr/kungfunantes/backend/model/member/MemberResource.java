package fr.kungfunantes.backend.model.member;

import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MemberResource {

	@Autowired
	private MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    @ResponseBody
	public Member byId(@PathVariable long id) {
        return RestPreconditions.checkFound(memberRepository.findById(id));
	}

    @GetMapping("/accounts/{id}/members")
    @ResponseBody
	public List<Member> byAcountId(@PathVariable long id) {
        return memberRepository.findByAccountId(id);
	}

    @GetMapping("/groups/{id}/members")
    @ResponseBody
	public List<Member> byGroupId(@PathVariable long id) {
        return memberRepository.findByGroupId(id);
	}

    @GetMapping("/evaluations/{id}/members")
    @ResponseBody
	public List<Member> byEvaluationId(@PathVariable long id) {
        return memberRepository.findByEvaluationId(id);
	}

    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Member> create(@RequestBody Member member) {
        Member savedMember = memberRepository.save(member);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/members/{id}")
                .buildAndExpand(savedMember.getId()).toUri();

        return ResponseEntity.created(location).body(savedMember);
    }
 
    @DeleteMapping("/members/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        memberRepository.deleteById(id);
    }

}
