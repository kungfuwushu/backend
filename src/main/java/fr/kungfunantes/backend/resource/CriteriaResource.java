package fr.kungfunantes.backend.resource;

import fr.kungfunantes.backend.model.criteria.Criteria;
import fr.kungfunantes.backend.repository.CriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Optional;

@RestController
public class CriteriaResource {

	@Autowired
	private CriteriaRepository criteriaRepository;

	@GetMapping("/criterion")
	@ResponseBody
	public List<Criteria> all() {
			return criteriaRepository.findAll();
	}

	@GetMapping("/criterion/{id}")
	@ResponseBody
	public Optional<Criteria> byId(@PathVariable("id") Long id) {
			return criteriaRepository.findById(id);
	}

	@PostMapping("/criterion")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Criteria create(@RequestBody Criteria criteria) {
    System.out.println(criteria);
		return Preconditions.checkNotNull(criteriaRepository.save(criteria));
	}
}
