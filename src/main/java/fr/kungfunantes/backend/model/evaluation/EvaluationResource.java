package fr.kungfunantes.backend.model.evaluation;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationResource {

	@Autowired
	private EvaluationRepository evaluationRepository;

    @GetMapping("/evaluations")
    @ResponseBody
    public List<Evaluation> all() {
        return evaluationRepository.findAll();
    }

    @GetMapping("/groups/{id}/upcoming-evaluations")
    @ResponseBody
	public List<Evaluation> upcomingByGroupId(@PathVariable Long id) {
        return evaluationRepository.upcomingByGroupId(id);
    }
    
    @GetMapping("/groups/{id}/past-evaluations")
    @ResponseBody
	public List<Evaluation> pastByGroupId(@PathVariable Long id) {
        return evaluationRepository.pastByGroupId(id);
	}

    @PostMapping("/evaluations")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Evaluation create(@RequestBody Evaluation evaluation) {
        return Preconditions.checkNotNull(evaluationRepository.save(evaluation));
    }
 
    @DeleteMapping("/evaluations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        evaluationRepository.deleteById(id);
    }
}
