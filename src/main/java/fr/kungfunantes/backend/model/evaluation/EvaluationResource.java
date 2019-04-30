package fr.kungfunantes.backend.model.evaluation;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationResource {

	@Autowired
	private EvaluationRepository evaluationRepository;

    @GetMapping("/evaluations/{id}")
    @ResponseBody
    public Evaluation byId(@PathVariable Long id) {
        return RestPreconditions.checkFound(evaluationRepository.findById(id));
    }

    @GetMapping("/evaluations")
    @ResponseBody
    public List<Evaluation> all() {
        return evaluationRepository.findAll();
    }

    @PostMapping("/evaluations")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Evaluation create(@RequestBody Evaluation evaluation) {
        return update(evaluation);
    }

    @PutMapping("/evaluations")
    @ResponseBody
    public Evaluation update(@RequestBody Evaluation evaluation) {
        return Preconditions.checkNotNull(evaluationRepository.save(evaluation));
    }
 
    @DeleteMapping("/evaluations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        evaluationRepository.deleteById(id);
    }
}
