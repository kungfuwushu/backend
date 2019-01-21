package fr.kungfunantes.backend.model.result.exercise;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.rank.exercise.RankExerciseRepository;
import fr.kungfunantes.backend.model.result.evaluation.EvaluationResultRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExerciseResultResource {

	@Autowired
	private ExerciseResultRepository exerciseResultRepository;

    @Autowired
    private RankExerciseRepository rankExerciseRepository;

    @Autowired
    private EvaluationResultRepository evaluationResultRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/evaluation-results/{id}/exercise-results")
    @ResponseBody
	public List<ExerciseResultDto> byEvaluationResultId(@PathVariable Long id) {
        return convertToDto(exerciseResultRepository.findByEvaluationResultId(id));
	}

    @PostMapping("/exercise-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExerciseResultDto create(@RequestBody ExerciseResultDto exerciseResultDto) {
        ExerciseResult exerciseResult = convertToEntity(exerciseResultDto);
        Preconditions.checkNotNull(exerciseResult);
        return convertToDto(exerciseResultRepository.save(exerciseResult));
    }
 
    @DeleteMapping("/exercise-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        exerciseResultRepository.deleteById(id);
    }

    private ExerciseResultDto convertToDto(ExerciseResult exerciseResult) {
        ExerciseResultDto exerciseResultDto = modelMapper.map(exerciseResult, ExerciseResultDto.class);
        exerciseResultDto.setRankExerciseId(exerciseResult.getRankExercise().getId());
        exerciseResultDto.setEvaluationResultId(exerciseResult.getEvaluationResult().getId());
        return exerciseResultDto;
    }

    private List<ExerciseResultDto> convertToDto(List<ExerciseResult> exerciseResults) {
        return exerciseResults.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ExerciseResult convertToEntity(ExerciseResultDto exerciseResultDto) throws ParseException {
        ExerciseResult exerciseResult = modelMapper.map(exerciseResultDto, ExerciseResult.class);
        exerciseResult.setRankExercise(
                RestPreconditions.checkFound(rankExerciseRepository.findById(exerciseResultDto.getRankExerciseId()))
        );
        exerciseResult.setEvaluationResult(
                RestPreconditions.checkFound(evaluationResultRepository.findById(exerciseResultDto.getEvaluationResultId()))
        );
        return exerciseResult;
    }
}
