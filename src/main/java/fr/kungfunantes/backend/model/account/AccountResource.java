package fr.kungfunantes.backend.model.account;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountResource {

	@Autowired
	private AccountRepository accountRepository;

    @GetMapping("/accounts")
    @ResponseBody
	public List<Account> all() {
        return accountRepository.findAll();
	}

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Account create(@RequestBody Account account) {
        Preconditions.checkNotNull(account);
        return accountRepository.save(account);
    }
 
    @DeleteMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        accountRepository.deleteById(id);
    }
}
