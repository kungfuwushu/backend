package fr.kungfunantes.backend.resource;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.Rank;
import fr.kungfunantes.backend.repository.RankRepository;
import fr.kungfunantes.backend.service.ExerciseScaleService;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankResource {

	@Autowired
	private RankRepository rankRepository;

	@Autowired
    private ExerciseScaleService exerciseScaleService;

    @GetMapping("/ranks")
    @ResponseBody
	public List<Rank> all() {
        return rankRepository.findByOrderByPositionAsc();
	}

    @GetMapping("/ranks/{id}")
    @ResponseBody
    public Rank byId(@PathVariable long id) {
        return RestPreconditions.checkFound(rankRepository.findById(id));
    }

    @PostMapping("/ranks")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Rank create(@RequestBody Rank rank) {
        rank.setPosition(rankRepository.findAll().size());
        return Preconditions.checkNotNull(rankRepository.save(rank));
    }

    @PutMapping("/ranks")
    @ResponseBody
    public Rank update(@RequestBody Rank updatedRank) {
        Rank rank = RestPreconditions.checkFound(rankRepository.findById(updatedRank.getId()));
        updatedRank.setExercisesScales(exerciseScaleService.update(
                rank.getExercisesScales(),
                updatedRank.getExercisesScales()
        ));
        return Preconditions.checkNotNull(rankRepository.save(updatedRank));
    }

    @PutMapping("/ranks/{id}/reorder")
    @ResponseStatus(HttpStatus.OK)
    public void reorder(
        @PathVariable long id,
        @RequestParam(value = "startIndex") int startIndex,
        @RequestParam(value = "endIndex") int endIndex) {
        List<Rank> ranks = all();
        ranks.add(endIndex, ranks.remove(startIndex));
        for (int i = 0; i < ranks.size(); i++)
            ranks.get(i).setPosition(i);
        rankRepository.saveAll(ranks);
    }
 
    @DeleteMapping("/ranks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankRepository.deleteById(id);
    }
}
