package fr.kungfunantes.backend.model.exercise;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseResource {

	@Autowired
	private ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    @ResponseBody
    public List<Exercise> byNameAndType(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) Exercise.Type type) {
        if (name != null && type != null)
            return exerciseRepository.findByNameLikeAndType(name, type);
        if (type != null)
            return exerciseRepository.findByType(type);
        if (name != null)
            return exerciseRepository.findByNameContaining(name);
        return exerciseRepository.findAll();
	}

    @GetMapping("/evaluations/{id}/exercises")
    @ResponseBody
	public List<Exercise> byEvaluationId(@PathVariable Long id) {
        return exerciseRepository.findByEvaluationId(id);
	}

    @GetMapping("/categories/{id}/exercises")
    @ResponseBody
	public List<Exercise> byCategoryId(@PathVariable Long id) {
        return exerciseRepository.findByCategoryId(id);
	}

    @PostMapping("/exercises")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Exercise create(@RequestBody Exercise exercise) {
        return Preconditions.checkNotNull(exerciseRepository.save(exercise));
    }
 
    @DeleteMapping("/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        exerciseRepository.deleteById(id);
    }
}
