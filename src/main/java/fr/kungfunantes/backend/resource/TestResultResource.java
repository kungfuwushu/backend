package fr.kungfunantes.backend.resource;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.model.Group;
import fr.kungfunantes.backend.model.Member;
import fr.kungfunantes.backend.model.test.Test;
import fr.kungfunantes.backend.model.test.TestResult;
import fr.kungfunantes.backend.repository.TestRepository;
import fr.kungfunantes.backend.repository.TestResultRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestResultResource {

    @Autowired
    private TestResultRepository testResultRepository;

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/tests/{id}/tests-results")
    @ResponseBody
    public List<TestResult> byTestId(@PathVariable Long id) {
        Test test = RestPreconditions.checkFound(testRepository.findById(id));
        for (Group group: test.getGroups())
            for (Member performer: group.getMembers())
                if (!testResultRepository.existsForTestIdAndPerformerId(id, performer.getId()))
                    testResultRepository.save(Preconditions.checkNotNull(TestResult.create(test, performer, group)));
        return testResultRepository.findAllByTestId(id);
    }

    @GetMapping("/members/{id}/tests-results")
    @ResponseBody
    public List<TestResult> byPerformerId(@PathVariable Long id) {
        return testResultRepository.findAllByPerformerId(id);
    }
}
