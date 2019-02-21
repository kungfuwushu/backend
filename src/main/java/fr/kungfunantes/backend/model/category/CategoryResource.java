package fr.kungfunantes.backend.model.category;

import com.google.common.base.Preconditions;
import fr.kungfunantes.backend.utils.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryResource {

	@Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories/{id}")
    @ResponseBody
	public Category byId(@PathVariable long id) {
        return RestPreconditions.checkFound(categoryRepository.findById(id));
	}

    @GetMapping("/categories")
    @ResponseBody
	public List<Category> byName(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return categoryRepository.findByNameContaining(name);
	}

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Category create(@RequestBody Category category) {
        return Preconditions.checkNotNull(categoryRepository.save(category));
    }
 
    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
    }
}
