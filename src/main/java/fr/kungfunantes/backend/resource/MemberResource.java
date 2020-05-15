package fr.kungfunantes.backend.resource;

import fr.kungfunantes.backend.model.Member;
import fr.kungfunantes.backend.repository.MemberRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberResource {

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("/members")
	@ResponseBody
	public List<Member> all() {
		return memberRepository.findAll();
	}

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

    @GetMapping("/tests/{id}/members")
    @ResponseBody
	public List<Member> byTestId(@PathVariable long id) {
        return memberRepository.findByTestId(id);
	}

}
