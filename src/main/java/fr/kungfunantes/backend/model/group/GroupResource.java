package fr.kungfunantes.backend.model.group;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupResource {

	@Autowired
	private GroupRepository groupRepository;

    @GetMapping("/groups")
    @ResponseBody
	public List<Group> byName(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return groupRepository.findByNameContaining(name);
	}

    @GetMapping("/groups/{id}")
    @ResponseBody
	public Group byId(@PathVariable long id) {
        return RestPreconditions.checkFound(groupRepository.findById(id));
	}

    @GetMapping("/evaluations/{id}/groups")
    @ResponseBody
	public List<Group> byEvaluationId(@PathVariable Long id) {
        return groupRepository.findByEvaluationId(id);
	}

    @PostMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Group create(@RequestBody Group group) {
        return Preconditions.checkNotNull(groupRepository.save(group));
    }

    @DeleteMapping("/groups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        groupRepository.deleteById(id);
    }
}
