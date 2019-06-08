package fr.kungfunantes.backend.resource;

import fr.kungfunantes.backend.model.Program;
import fr.kungfunantes.backend.model.Rank;
import fr.kungfunantes.backend.repository.RankRepository;
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
    private ProgramResource programResource;

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

    @GetMapping("/tests/{id}/ranks")
    @ResponseBody
    public List<Rank> byTestId(@PathVariable long id) {
        return rankRepository.findAllByTestId(id);
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

    @PostMapping("/ranks")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Program create(@RequestBody Rank rank) {
        return programResource.create(rank);
    }

    @PutMapping("/ranks")
    @ResponseBody
    public Program update(@RequestBody Rank rank) {
        return programResource.update(rank);
    }

    @DeleteMapping("/ranks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        programResource.delete(id);
    }
}
