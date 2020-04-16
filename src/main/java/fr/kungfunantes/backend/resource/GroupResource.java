package fr.kungfunantes.backend.resource;

import fr.kungfunantes.backend.model.Group;
import fr.kungfunantes.backend.repository.GroupRepository;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.google.common.base.Preconditions;

import java.util.List;

@RestController
public class GroupResource {

	@Autowired
	private GroupRepository groupRepository;

    @GetMapping("/groups")
    @ResponseBody
	public List<Group> all() {
        return groupRepository.findAll();
	}

    @GetMapping("/groups/{id}")
    @ResponseBody
	public Group byId(@PathVariable long id) {
        return RestPreconditions.checkFound(groupRepository.findById(id));
	}

	@PostMapping("/groups")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Group create(@RequestBody Group group) {
		return Preconditions.checkNotNull(groupRepository.save(group));

	}

	@DeleteMapping("/group/{id}")
	public void deleteGroup(@PathVariable long id) {
		groupRepository.deleteById(id);
	}

    @GetMapping("/tests/{id}/groups")
    @ResponseBody
	public List<Group> byTestId(@PathVariable Long id) {
        return groupRepository.findByTestId(id);
	}
}
