package fr.kungfunantes.backend.resource;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.test.Test;
import fr.kungfunantes.backend.model.test.program.ProgramTest;
import fr.kungfunantes.backend.repository.TestRepository;
import fr.kungfunantes.backend.service.ExerciseScaleService;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestResource {

	@Autowired
	private TestRepository testRepository;

    @Autowired
    private ExerciseScaleService exerciseScaleService;

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
    public Test update(@RequestBody Test updatedTest) {
        Test test = RestPreconditions.checkFound(testRepository.findById(updatedTest.getId()));
        if (test instanceof ProgramTest && updatedTest instanceof ProgramTest)
            ((ProgramTest) updatedTest).setExercisesScales(exerciseScaleService.update(
                    ((ProgramTest) test).getExercisesScales(),
                    ((ProgramTest) updatedTest).getExercisesScales()
            ));
        return Preconditions.checkNotNull(testRepository.save(updatedTest));
    }
}
