package fr.kungfunantes.backend.model.rank.criteria;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.criteria.CriteriaRepository;
import fr.kungfunantes.backend.model.rank.exercise.RankExerciseDto;
import fr.kungfunantes.backend.model.rank.exercise.RankExerciseRepository;
import fr.kungfunantes.backend.model.rank.exercise.RankExerciseResource;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RankCriteriaResource {

	@Autowired
	private RankCriteriaRepository rankCriteriaRepository;

    @Autowired
    private RankExerciseRepository rankExerciseRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/ranks-exercises/{id}/rank-criterias")
    @ResponseBody
	public List<RankCriteriaDto> byRankId(@PathVariable Long id) {
        return convertToDto(rankCriteriaRepository.findByRankExerciseId(id));
	}

    @PostMapping("/rank-criterias")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RankCriteriaDto create(@RequestBody RankCriteriaDto rankCriteriaDto) {
        RankCriteria rankCriteria = convertToEntity(rankCriteriaDto);
        Preconditions.checkNotNull(rankCriteria);
        return convertToDto(rankCriteriaRepository.save(rankCriteria));
    }
 
    @DeleteMapping("/rank-criterias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankCriteriaRepository.deleteById(id);
    }

    private RankCriteriaDto convertToDto(RankCriteria rankCriteria) {
        RankCriteriaDto rankCriteriaDto = modelMapper.map(rankCriteria, RankCriteriaDto.class);
        rankCriteriaDto.setCriteriaId(rankCriteria.getCriteria().getId());
        rankCriteriaDto.setRankExerciseId(rankCriteria.getRankExercise().getId());
        return rankCriteriaDto;
    }

    private List<RankCriteriaDto> convertToDto(List<RankCriteria> rankCriterias) {
        return rankCriterias.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private RankCriteria convertToEntity(RankCriteriaDto rankCriteriaDto) throws ParseException {
        RankCriteria rankCriteria = modelMapper.map(rankCriteriaDto, RankCriteria.class);
        rankCriteria.setRankExercise(
                RestPreconditions.checkFound(rankExerciseRepository.findById(rankCriteriaDto.getRankExerciseId()))
        );
        rankCriteria.setCriteria(
                RestPreconditions.checkFound(criteriaRepository.findById(rankCriteriaDto.getCriteriaId()))
        );
        return rankCriteria;
    }
}
