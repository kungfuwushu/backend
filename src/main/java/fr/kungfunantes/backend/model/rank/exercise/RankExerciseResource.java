package fr.kungfunantes.backend.model.rank.exercise;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.exercise.ExerciseRepository;
import fr.kungfunantes.backend.model.rank.RankRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RankExerciseResource {

	@Autowired
	private RankExerciseRepository rankExerciseRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/ranks/{id}/rank-exercises")
    @ResponseBody
	public List<RankExerciseDto> byRankId(@PathVariable Long id) {
        return convertToDto(rankExerciseRepository.findByRankId(id));
	}

    @PostMapping("/rank-exercises")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RankExerciseDto create(@RequestBody RankExerciseDto rankExerciseDto) {
        RankExercise rankExercise = convertToEntity(rankExerciseDto);
        Preconditions.checkNotNull(rankExercise);
        return convertToDto(rankExerciseRepository.save(rankExercise));
    }
 
    @DeleteMapping("/rank-exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankExerciseRepository.deleteById(id);
    }

    private RankExerciseDto convertToDto(RankExercise rankExercise) {
        RankExerciseDto rankExerciseDto = modelMapper.map(rankExercise, RankExerciseDto.class);
        rankExerciseDto.setExerciseId(rankExercise.getExercise().getId());
        rankExerciseDto.setRankId(rankExercise.getRank().getId());
        return rankExerciseDto;
    }

    private List<RankExerciseDto> convertToDto(List<RankExercise> rankExercises) {
        return rankExercises.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private RankExercise convertToEntity(RankExerciseDto rankExerciseDto) throws ParseException {
        RankExercise rankExercise = modelMapper.map(rankExerciseDto, RankExercise.class);
        rankExercise.setExercise(
                RestPreconditions.checkFound(exerciseRepository.findById(rankExerciseDto.getExerciseId()))
        );
        rankExercise.setRank(
                RestPreconditions.checkFound(rankRepository.findById(rankExerciseDto.getRankId()))
        );
        return rankExercise;
    }
}
