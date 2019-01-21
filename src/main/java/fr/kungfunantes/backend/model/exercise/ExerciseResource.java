package fr.kungfunantes.backend.model.exercise;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.category.CategoryRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExerciseResource {

	@Autowired
	private ExerciseRepository exerciseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/exercises")
    @ResponseBody
    public List<ExerciseDto> byNameAndType(@RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "type", required = false) String type) {
        return convertToDto(exerciseRepository.findByNameAndType(name, type));
	}

    @GetMapping("/evaluations/{id}/exercises")
    @ResponseBody
	public List<ExerciseDto> byEvaluationId(@PathVariable Long id) {
        return convertToDto(exerciseRepository.findByEvaluationId(id));
	}

    @GetMapping("/categories/{id}/exercises")
    @ResponseBody
	public List<ExerciseDto> byCategoryId(@PathVariable Long id) {
        return convertToDto(exerciseRepository.findByCategoryId(id));
	}

    @PostMapping("/exercises")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExerciseDto create(@RequestBody ExerciseDto exerciseDto) {
        Exercise exercise = convertToEntity(exerciseDto);
        Preconditions.checkNotNull(exercise);
        return convertToDto(exerciseRepository.save(exercise));
    }
 
    @DeleteMapping("/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        exerciseRepository.deleteById(id);
    }

    private ExerciseDto convertToDto(Exercise exercise) {
        ExerciseDto exerciseDto = modelMapper.map(exercise, ExerciseDto.class);
        exerciseDto.setCategoryId(exercise.getCategory().getId());
        return exerciseDto;
    }

    private List<ExerciseDto> convertToDto(List<Exercise> exercises) {
        return exercises.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Exercise convertToEntity(ExerciseDto exerciseDto) throws ParseException {
        Exercise exercise = modelMapper.map(exerciseDto, Exercise.class);
        exercise.setCategory(
                RestPreconditions.checkFound(categoryRepository.findById(exerciseDto.getCategoryId()))
        );
        return exercise;
    }
}
