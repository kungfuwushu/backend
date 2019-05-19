package fr.kungfunantes.backend.service;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.exercise.ExerciseScale;
import fr.kungfunantes.backend.repository.ExerciseResultRepository;
import fr.kungfunantes.backend.repository.ExerciseScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExerciseScaleService {
    @Autowired
    private ExerciseScaleRepository exerciseScaleRepository;

    @Autowired
    private ExerciseResultRepository exerciseResultRepository;

    public List<ExerciseScale> update(List<ExerciseScale> before, List<ExerciseScale> after) {
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
}
