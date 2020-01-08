package fr.kungfunantes.backend.resource;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.repository.ExerciseRepository;
import fr.kungfunantes.backend.repository.ExerciseCriteriaRepository;
import fr.kungfunantes.backend.repository.ExerciseRoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseResource {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private ExerciseCriteriaRepository exerciseCriteriaRepository;

	@Autowired
	private ExerciseRoundRepository exerciseRoundRepository;

	@GetMapping("/exercises")
	@ResponseBody
	public List<Exercise> all() {
			return exerciseRepository.findAll();
	}

	@GetMapping("/exercises/{id}")
	@ResponseBody
	public Optional<Exercise> byId(@PathVariable("id") Long id) {
			return exerciseRepository.findById(id);
	}

	@DeleteMapping("/exercises/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public void delete(@PathVariable("id") Long id) {
		System.out.println("COUCOU");
			String exerciseType = byId(id).get().getType();
			switch(exerciseType) {
				case "TAOLU":
					exerciseCriteriaRepository.deleteById(id);
					exerciseRepository.deleteById(id);
					break;
				case "FIGHT":
					exerciseRoundRepository.deleteById(id);
					exerciseRepository.deleteById(id);
					break;
				default:
					exerciseRepository.deleteById(id);
			}
	}

}
