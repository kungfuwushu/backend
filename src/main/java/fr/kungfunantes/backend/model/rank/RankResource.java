package fr.kungfunantes.backend.model.rank;

import com.google.common.base.Preconditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RankResource {

	@Autowired
	private RankRepository rankRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/ranks")
    @ResponseBody
	public List<RankDto> byName(@RequestParam(value = "name", required = true) String name) {
        return convertToDto(rankRepository.findByName(name));
	}

    @PostMapping("/ranks")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RankDto create(@RequestBody RankDto rankDto) {
        Rank rank = convertToEntity(rankDto);
        Preconditions.checkNotNull(rank);
        return convertToDto(rankRepository.save(rank));
    }
 
    @DeleteMapping("/ranks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        rankRepository.deleteById(id);
    }

    private RankDto convertToDto(Rank rank) {
        return modelMapper.map(rank, RankDto.class);
    }

    private List<RankDto> convertToDto(List<Rank> ranks) {
        return ranks.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Rank convertToEntity(RankDto rankDto) throws ParseException {
        return modelMapper.map(rankDto, Rank.class);
    }
}
