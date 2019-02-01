package fr.kungfunantes.backend.model.rank.criteria;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankCriteriaResource {

	@Autowired
	private RankCriteriaRepository rankCriteriaRepository;

    @DeleteMapping("/rank-criterias")
    @ResponseBody
    public void deleteAll() {
        rankCriteriaRepository.deleteAll(rankCriteriaRepository.findAll());
    }

    @GetMapping("/rank-exercises/{id}/rank-criterias")
    @ResponseBody
	public List<RankCriteria> byRankExerciseId(@PathVariable Long id) {
        return rankCriteriaRepository.findByRankExerciseId(id);
	}

    @GetMapping("/evaluations/{id}/rank-criterias")
    @ResponseBody
    public List<RankCriteria> byEvaluationId(@PathVariable Long id) {
        return rankCriteriaRepository.findByEvaluationId(id);
    }


    @PostMapping("/rank-criterias")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RankCriteria create(@RequestBody RankCriteria rankCriteria) {
        return Preconditions.checkNotNull(rankCriteriaRepository.save(rankCriteria));
    }
 
    @DeleteMapping("/rank-criterias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankCriteriaRepository.deleteById(id);
    }
}
