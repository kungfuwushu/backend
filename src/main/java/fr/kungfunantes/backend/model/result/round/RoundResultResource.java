package fr.kungfunantes.backend.model.result.round;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoundResultResource {

    @Autowired
    private RoundResultRepository roundResultRepository;

    @PostMapping("/round-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RoundResult create(@RequestBody RoundResult roundResult) {
        return Preconditions.checkNotNull(roundResultRepository.save(roundResult));
    }

    @DeleteMapping("/round-results/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        roundResultRepository.deleteById(id);
    }
}
