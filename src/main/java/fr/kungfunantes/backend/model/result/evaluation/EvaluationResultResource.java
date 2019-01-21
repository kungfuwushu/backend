package fr.kungfunantes.backend.model.result.evaluation;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.evaluation.EvaluationRepository;
import fr.kungfunantes.backend.model.group.GroupRepository;
import fr.kungfunantes.backend.model.member.MemberRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EvaluationResultResource {

	@Autowired
	private EvaluationResultRepository evaluationResultRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/evaluations/{id}/evaluation-results")
    @ResponseBody
	public List<EvaluationResultDto> byEvaluationId(@PathVariable Long id) {
        return convertToDto(evaluationResultRepository.findByEvaluationId(id));
	}

    @GetMapping("/members/{id}/evaluation-results")
    @ResponseBody
	public List<EvaluationResultDto> byMemberId(@PathVariable Long id) {
        return convertToDto(evaluationResultRepository.findByMemberId(id));
	}

    @PostMapping("/evaluation-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EvaluationResultDto create(@RequestBody EvaluationResultDto evaluationResultDto) {
        EvaluationResult evaluationResult = convertToEntity(evaluationResultDto);
        Preconditions.checkNotNull(evaluationResult);
        return convertToDto(evaluationResultRepository.save(evaluationResult));
    }
 
    @DeleteMapping("/evaluation-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        evaluationResultRepository.deleteById(id);
    }

    private EvaluationResultDto convertToDto(EvaluationResult evaluationResult) {
        EvaluationResultDto evaluationResultDto = modelMapper.map(evaluationResult, EvaluationResultDto.class);
        evaluationResultDto.setEvaluationId(evaluationResult.getEvaluation().getId());
        evaluationResultDto.setGroupId(evaluationResult.getGroup().getId());
        evaluationResultDto.setPerformerId(evaluationResult.getPerformer().getId());
        return evaluationResultDto;
    }

    private List<EvaluationResultDto> convertToDto(List<EvaluationResult> evaluationResults) {
        return evaluationResults.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private EvaluationResult convertToEntity(EvaluationResultDto evaluationResultDto) throws ParseException {
        EvaluationResult evaluationResult = modelMapper.map(evaluationResultDto, EvaluationResult.class);
        evaluationResult.setEvaluation(
                RestPreconditions.checkFound(evaluationRepository.findById(evaluationResultDto.getEvaluationId()))
        );
        evaluationResult.setGroup(
                RestPreconditions.checkFound(groupRepository.findById(evaluationResultDto.getGroupId()))
        );
        evaluationResult.setPerformer(
                RestPreconditions.checkFound(memberRepository.findById(evaluationResultDto.getPerformerId()))
        );
        return evaluationResult;
    }
}
