package fr.kungfunantes.backend.model.result.criteria;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CriteriaResultResource {

	@Autowired
	private CriteriaResultRepository criteriaResultRepository;

    @GetMapping("/exercise-results/{id}/criteria-results")
    @ResponseBody
	public List<CriteriaResult> byExerciseResultId(@PathVariable Long id) {
        return criteriaResultRepository.findByExerciseResultId(id);
	}

    @PostMapping("/criteria-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CriteriaResult create(@RequestBody CriteriaResult criteriaResult) {
        return Preconditions.checkNotNull(criteriaResultRepository.save(criteriaResult));
    }
 
    @DeleteMapping("/criteria-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        criteriaResultRepository.deleteById(id);
    }
}
