package fr.kungfunantes.backend.resource;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.test.Test;
import fr.kungfunantes.backend.repository.TestRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestResource {

	@Autowired
	private TestRepository testRepository;

    @GetMapping("/tests")
    @ResponseBody
    public List<Test> all() {
        return testRepository.findAll();
    }

    @GetMapping("/tests/{id}")
    @ResponseBody
    public Test byId(@PathVariable Long id) {
        return RestPreconditions.checkFound(testRepository.findById(id));
    }

    @PostMapping("/tests")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Test create(@RequestBody Test test) {
        return update(test);
    }

    @PutMapping("/tests")
    @ResponseBody
    public Test update(@RequestBody Test test) {
        return Preconditions.checkNotNull(testRepository.save(test));
    }
}
