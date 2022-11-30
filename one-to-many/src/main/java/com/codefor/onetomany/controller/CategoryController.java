package com.codefor.onetomany.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefor.onetomany.model.Category;
import com.codefor.onetomany.model.dto.CategoryDto;
import com.codefor.onetomany.service.CategoryService;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	@PostMapping
	public ResponseEntity<CategoryDto> addCategory(@RequestBody final CategoryDto categoryDto){
		Category category = categoryService.addCategory(Category.from(categoryDto));
		return new ResponseEntity<>(CategoryDto.from(category),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getCategorys(){
		List<Category> categorys = categoryService.getCategorys();
		List<CategoryDto> categorysDto = categorys.stream().map(CategoryDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(categorysDto, HttpStatus.OK);
		}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable final Long id){
		Category category = categoryService.getCategory(id);
		return new ResponseEntity<>(CategoryDto.from(category),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<CategoryDto> deleteCategory(@PathVariable final Long id){
		Category category = categoryService.deleteCategory(id);
		return new ResponseEntity<>(CategoryDto.from(category),HttpStatus.OK);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<CategoryDto> editCategory(@PathVariable final Long id, @RequestBody final CategoryDto categoryDto){
		Category category = categoryService.editCategory(id, Category.from(categoryDto));
		return new ResponseEntity<>(CategoryDto.from(category),HttpStatus.OK);
	}
	
	@PostMapping(value="{categoryId}/items/{itemId}/add")
	public ResponseEntity<CategoryDto> addItemToCategory(@PathVariable final Long categoryId,@PathVariable final Long itemId){
		Category category= CategoryService.addItemToCategory(categoryId, itemId);
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{categoryId}/items/{itemId}/remove")
	public ResponseEntity<CategoryDto> removeItemFromCategory(@PathVariable final Long categoryId,@PathVariable final Long itemId){
		Category category= CategoryService.removeItemFromCategory(categoryId, itemId);
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}
}












