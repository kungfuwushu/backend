package fr.kungfunantes.backend.model.evaluation;

import com.google.common.base.Preconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EvaluationResource {

	@Autowired
	private EvaluationRepository evaluationRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/groups/{id}/upcoming-evaluations")
    @ResponseBody
	public List<EvaluationDto> upcomingByGroupId(@PathVariable Long id) {
        return convertToDto(evaluationRepository.upcomingByGroupId(id));
    }
    
    @GetMapping("/groups/{id}/past-evaluations")
    @ResponseBody
	public List<EvaluationDto> pastByGroupId(@PathVariable Long id) {
        return convertToDto(evaluationRepository.pastByGroupId(id));
	}

    @PostMapping("/evaluations")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EvaluationDto create(@RequestBody EvaluationDto evaluationDto) {
        Evaluation evaluation = convertToEntity(evaluationDto);
        Preconditions.checkNotNull(evaluation);
        return convertToDto(evaluationRepository.save(evaluation));
    }
 
    @DeleteMapping("/evaluations/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        evaluationRepository.deleteById(id);
    }

    private EvaluationDto convertToDto(Evaluation evaluation) {
        return modelMapper.map(evaluation, EvaluationDto.class);
    }

    private List<EvaluationDto> convertToDto(List<Evaluation> evaluations) {
        return evaluations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Evaluation convertToEntity(EvaluationDto evaluationDto) throws ParseException {
        return modelMapper.map(evaluationDto, Evaluation.class);
    }
}
