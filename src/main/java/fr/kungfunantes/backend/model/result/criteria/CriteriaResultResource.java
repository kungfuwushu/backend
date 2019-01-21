package fr.kungfunantes.backend.model.result.criteria;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.rank.criteria.RankCriteria;
import fr.kungfunantes.backend.model.rank.criteria.RankCriteriaRepository;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResult;
import fr.kungfunantes.backend.model.result.exercise.ExerciseResultRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CriteriaResultResource {

	@Autowired
	private CriteriaResultRepository criteriaResultRepository;

    @Autowired
    private ExerciseResultRepository exerciseResultRepository;

    @Autowired
    private RankCriteriaRepository rankCriteriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/exercise-results/{id}/criteria-results")
    @ResponseBody
	public List<CriteriaResultDto> byExerciseResultId(@PathVariable Long id) {
        return convertToDto(criteriaResultRepository.findByExerciseResultId(id));
	}

    @PostMapping("/criteria-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CriteriaResultDto create(@RequestBody CriteriaResultDto criteriaResultDto) {
        CriteriaResult criteriaResult = convertToEntity(criteriaResultDto);
        Preconditions.checkNotNull(criteriaResult);
        return convertToDto(criteriaResultRepository.save(criteriaResult));
    }
 
    @DeleteMapping("/criteria-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        criteriaResultRepository.deleteById(id);
    }

    private CriteriaResultDto convertToDto(CriteriaResult criteriaResult) {
        CriteriaResultDto criteriaResultDto = modelMapper.map(criteriaResult, CriteriaResultDto.class);
        criteriaResultDto.setExerciseResultId(criteriaResult.getExerciseResult().getId());
        criteriaResultDto.setRankCriteriaId(criteriaResult.getRankCriteria().getId());
        return criteriaResultDto;
    }

    private List<CriteriaResultDto> convertToDto(List<CriteriaResult> criteriaResults) {
        return criteriaResults.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CriteriaResult convertToEntity(CriteriaResultDto criteriaResultDto) throws ParseException {
        CriteriaResult criteriaResult = modelMapper.map(criteriaResultDto, CriteriaResult.class);
        criteriaResult.setExerciseResult(
                RestPreconditions.checkFound(exerciseResultRepository.findById(criteriaResultDto.getExerciseResultId()))
        );
        criteriaResult.setRankCriteria(
                RestPreconditions.checkFound(rankCriteriaRepository.findById(criteriaResultDto.getRankCriteriaId()))
        );
        return criteriaResult;
    }
}
