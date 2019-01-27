package fr.kungfunantes.backend.model.result.exercise;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseResultResource {

	@Autowired
	private ExerciseResultRepository exerciseResultRepository;

    @GetMapping("/evaluation-results/{id}/exercise-results")
    @ResponseBody
	public List<ExerciseResult> byEvaluationResultId(@PathVariable Long id) {
        return exerciseResultRepository.findByEvaluationResultId(id);
	}

    @PostMapping("/exercise-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExerciseResult create(@RequestBody ExerciseResult exerciseResult) {
        return Preconditions.checkNotNull(exerciseResultRepository.save(exerciseResult));
    }
 
    @DeleteMapping("/exercise-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        exerciseResultRepository.deleteById(id);
    }
}
