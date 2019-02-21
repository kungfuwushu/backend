package fr.kungfunantes.backend.model.result.evaluation;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationResultResource {

	@Autowired
	private EvaluationResultRepository evaluationResultRepository;

    @GetMapping("/evaluations/{id}/evaluation-results")
    @ResponseBody
	public List<EvaluationResult> byEvaluationId(@PathVariable Long id) {
        return evaluationResultRepository.findByEvaluationId(id);
	}

    @GetMapping("/members/{id}/evaluation-results")
    @ResponseBody
	public List<EvaluationResult> byMemberId(@PathVariable Long id) {
        return evaluationResultRepository.findByMemberId(id);
	}

    @PostMapping("/evaluation-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EvaluationResult create(@RequestBody EvaluationResult evaluationResult) {
        return Preconditions.checkNotNull(evaluationResultRepository.save(evaluationResult));
    }
 
    @DeleteMapping("/evaluation-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        evaluationResultRepository.deleteById(id);
    }
}
