package fr.kungfunantes.backend.resource;

import fr.kungfunantes.backend.model.exercise.Exercise;
import fr.kungfunantes.backend.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseResource {

	@Autowired
	private ExerciseRepository exerciseRepository;

    @GetMapping("/exercises")
    @ResponseBody
    public List<Exercise> all() {
        return exerciseRepository.findAll();
	}
}
