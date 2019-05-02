package fr.kungfunantes.backend.resource;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.exercise.ExerciseResult;
import fr.kungfunantes.backend.model.test.TestResult;
import fr.kungfunantes.backend.repository.ExerciseResultRepository;
import fr.kungfunantes.backend.repository.TestResultRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseResultResource {

    @Autowired
    private ExerciseResultRepository exerciseResultRepository;

    @Autowired
    private TestResultRepository testResultRepository;

    @GetMapping("/tests-results/{testResultId}/exercises-results")
    @ResponseBody
    public List<ExerciseResult> byTestResultIdAndExerciseScaleId(@PathVariable Long testResultId, @RequestParam(value = "exerciseScaleId") Long exerciseScaleId) {
        return exerciseResultRepository.findAllByTestResultIdAndExerciseScaleId(testResultId, exerciseScaleId);
    }

    @PostMapping("/tests-results/{id}/exercises-results")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ExerciseResult create(@PathVariable Long id, @RequestBody ExerciseResult exerciseResult) {
        TestResult testResult = RestPreconditions.checkFound(testResultRepository.findById(id));
        exerciseResult = Preconditions.checkNotNull(exerciseResultRepository.save(exerciseResult));
        testResult.getExercisesResults().add(exerciseResult);
        testResultRepository.save(testResult);
        return exerciseResult;
    }

    @PutMapping("/tests-results/{id}/exercises-results")
    @ResponseBody
    public ExerciseResult update(@PathVariable Long id, @RequestBody ExerciseResult exerciseResult) {
        return Preconditions.checkNotNull(exerciseResultRepository.save(exerciseResult));
    }
}
