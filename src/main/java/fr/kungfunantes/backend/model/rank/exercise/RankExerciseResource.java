package fr.kungfunantes.backend.model.rank.exercise;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankExerciseResource {

	@Autowired
	private RankExerciseRepository rankExerciseRepository;

    @GetMapping("/ranks/{id}/rank-exercises")
    @ResponseBody
	public List<RankExercise> byRankId(@PathVariable Long id) {
        return rankExerciseRepository.findByRankId(id);
	}

    @PostMapping("/rank-exercises")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RankExercise create(@RequestBody RankExercise rankExercise) {
        return Preconditions.checkNotNull(rankExerciseRepository.save(rankExercise));
    }
 
    @DeleteMapping("/rank-exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankExerciseRepository.deleteById(id);
    }
}
