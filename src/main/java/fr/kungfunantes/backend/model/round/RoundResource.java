package fr.kungfunantes.backend.model.round;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoundResource {

    @Autowired
    private RoundRepository roundRepository;

    @PostMapping("/rounds")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Round create(@RequestBody Round round) {
        return Preconditions.checkNotNull(roundRepository.save(round));
    }

    @DeleteMapping("/rounds/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        roundRepository.deleteById(id);
    }
}
