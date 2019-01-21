package fr.kungfunantes.backend.model.criteria;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.exercise.ExerciseRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CriteriaResource {

	@Autowired
	private CriteriaRepository criteriaRepository;

	@Autowired
	private ExerciseRepository exerciseRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/exercises/{id}/criterias")
    @ResponseBody
	public List<CriteriaDto> byExerciseId(@PathVariable Long id) {
        return convertToDto(criteriaRepository.findByExerciseId(id));
	}

    @PostMapping("/criterias")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CriteriaDto create(@RequestBody CriteriaDto criteriaDto) {
        Criteria criteria = convertToEntity(criteriaDto);
        Preconditions.checkNotNull(criteria);
        return convertToDto(criteriaRepository.save(criteria));
    }
 
    @DeleteMapping("/criterias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        criteriaRepository.deleteById(id);
    }

    private CriteriaDto convertToDto(Criteria criteria) {
        CriteriaDto criteriaDto = modelMapper.map(criteria, CriteriaDto.class);
        criteriaDto.setExerciseId(criteria.getExercise().getId());
        return criteriaDto;
    }

    private List<CriteriaDto> convertToDto(List<Criteria> criterias) {
        return criterias.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Criteria convertToEntity(CriteriaDto criteriaDto) throws ParseException {
        Criteria criteria = modelMapper.map(criteriaDto, Criteria.class);
        criteria.setExercise(RestPreconditions.checkFound(exerciseRepository.findById(criteriaDto.getExerciseId())));
        return criteria;
    }
}
