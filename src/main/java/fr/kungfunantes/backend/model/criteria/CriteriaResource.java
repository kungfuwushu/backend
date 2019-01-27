package fr.kungfunantes.backend.model.criteria;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriteriaResource {

	@Autowired
	private CriteriaRepository criteriaRepository;

    @GetMapping("/exercises/{id}/criterias")
    @ResponseBody
	public List<Criteria> byExerciseId(@PathVariable Long id) {
        return criteriaRepository.findByExerciseId(id);
	}

    @PostMapping("/criterias")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Criteria create(@RequestBody Criteria criteria) {
        return Preconditions.checkNotNull(criteriaRepository.save(criteria));
    }
 
    @DeleteMapping("/criterias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        criteriaRepository.deleteById(id);
    }
}
