package fr.kungfunantes.backend.model.rank.round;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RankRoundResource {

    @Autowired
    private RankRoundRepository rankRoundRepository;

    @PostMapping("/rank-rounds")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RankRound create(@RequestBody RankRound rankRound) {
        return Preconditions.checkNotNull(rankRoundRepository.save(rankRound));
    }

    @DeleteMapping("/rank-rounds/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankRoundRepository.deleteById(id);
    }
}
