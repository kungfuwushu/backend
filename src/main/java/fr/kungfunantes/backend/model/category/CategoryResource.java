package fr.kungfunantes.backend.model.category;

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
public class CategoryResource {

	@Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/categories/{id}")
    @ResponseBody
	public CategoryDto byId(@PathVariable long id) {
        return convertToDto(RestPreconditions.checkFound(categoryRepository.findById(id)));
	}

    @GetMapping("/categories")
    @ResponseBody
	public List<CategoryDto> byName(@RequestParam(value = "name", required = true) String name) {
        return convertToDto(categoryRepository.findByName(name));
	}

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        Preconditions.checkNotNull(categoryDto);
        Category category = convertToEntity(categoryDto);
        return convertToDto(categoryRepository.save(category));
    }
 
    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        if (category.getParent() != null)
            categoryDto.setParentId(category.getParent().getId());
        List<Long> subCategoriesId = category.getSubCategories().stream().map(Category::getId).collect(Collectors.toList());
        categoryDto.setSubCategoriesId(subCategoriesId);
        return categoryDto;
    }

    private List<CategoryDto> convertToDto(List<Category> categories) {
        return categories.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private Category convertToEntity(CategoryDto categoryDto) throws ParseException {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setSubCategories(categoryRepository.findAllById(categoryDto.getSubCategoriesId()));
        if (categoryDto.getParentId() != null)
            category.setParent(RestPreconditions.checkFound(categoryRepository.findById(categoryDto.getParentId())));
        return category;
    }
}
