package fr.kungfunantes.backend.resource;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.Program;
import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import fr.kungfunantes.backend.repository.ExerciseResultRepository;
import fr.kungfunantes.backend.repository.ExerciseScaleRepository;
import fr.kungfunantes.backend.repository.ProgramRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProgramResource {

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private ExerciseScaleRepository exerciseScaleRepository;

    @Autowired
    private ExerciseResultRepository exerciseResultRepository;

    @GetMapping("/programs")
    @ResponseBody
    public List<Program> all() {
        return programRepository.findAll();
    }

    @GetMapping("/programs/{id}")
    @ResponseBody
    public Program byId(@PathVariable long id) {
        return RestPreconditions.checkFound(programRepository.findById(id));
    }

    @PostMapping("/programs")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Program create(@RequestBody Program program) {
        return Preconditions.checkNotNull(programRepository.save(program));
    }

    @PutMapping("/programs")
    @ResponseBody
    public Program update(@RequestBody Program updatedProgram) {
        Program program = RestPreconditions.checkFound(programRepository.findById(updatedProgram.getId()));
        updatedProgram.setExercisesScales(update(
                program.getExercisesScales(),
                updatedProgram.getExercisesScales()
        ));
        return Preconditions.checkNotNull(programRepository.save(updatedProgram));
    }

    private List<ExerciseScale> update(List<ExerciseScale> before, List<ExerciseScale> after) {
        List<ExerciseScale> result = new ArrayList<>();

        for (ExerciseScale exerciseAfter: after) {
            Optional<ExerciseScale> optBefore = before.stream()
                    .filter(o -> o.getId().equals(exerciseAfter.getId()))
                    .findFirst();

            if (!optBefore.isPresent() || optBefore.get().equals(exerciseAfter) ||
                    !exerciseResultRepository.existsWithExerciseScaleId(optBefore.get().getId()))
                result.add(exerciseAfter);
            else {
                ExerciseScale exerciseBefore = optBefore.get();
                ExerciseScale clone = Preconditions.checkNotNull(exerciseScaleRepository.save(exerciseAfter.clone()));
                exerciseBefore.setNewestVersion(clone);
                exerciseScaleRepository.save(exerciseBefore);
                exerciseScaleRepository.updateNewestVersionId(exerciseBefore.getId(), clone.getId());
                result.add(clone);
            }
        }

        return result;
    }

    @DeleteMapping("/programs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        programRepository.deleteById(id);
    }
}
