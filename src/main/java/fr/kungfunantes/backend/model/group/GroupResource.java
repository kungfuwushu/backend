package fr.kungfunantes.backend.model.group;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroupResource {

	@Autowired
	private GroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/groups")
    @ResponseBody
	public List<GroupDto> byName(@RequestParam(value = "name", required = false) String name) {
        return convertToDto(groupRepository.findByName(name));
	}

    @GetMapping("/groups/{id}")
    @ResponseBody
	public GroupDto byId(@PathVariable long id) {
        return convertToDto(RestPreconditions.checkFound(groupRepository.findById(id)));
	}

    @GetMapping("/evaluations/{id}/groups")
    @ResponseBody
	public List<GroupDto> byEvaluationId(@PathVariable Long id) {
        return convertToDto(groupRepository.findByEvaluationId(id));
	}

    @PostMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GroupDto create(@RequestBody GroupDto groupDto) {
        Group group = convertToEntity(groupDto);
        Preconditions.checkNotNull(group);
        return convertToDto(groupRepository.save(group));
    }

    @DeleteMapping("/groups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        groupRepository.deleteById(id);
    }

    private GroupDto convertToDto(Group group) {
        return modelMapper.map(group, GroupDto.class);
    }

    private List<GroupDto> convertToDto(List<Group> groups) {
        return groups.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Group convertToEntity(GroupDto groupDto) throws ParseException {
        return modelMapper.map(groupDto, Group.class);
    }
}
