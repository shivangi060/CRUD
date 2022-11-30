package com.codefor.onetomany.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefor.onetomany.model.Category;
import com.codefor.onetomany.model.Item;
import com.codefor.onetomany.model.exception.CategoryNotFoundException;
import com.codefor.onetomany.model.exception.ItemIsAlreadyAssignedException;
import com.codefor.onetomany.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	
	private static  CategoryRepository categoryRepository = null;
	private  static ItemService itemService;
	
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository, ItemService itemService) {
		super();
		this.categoryRepository = categoryRepository;
		this.itemService = itemService;
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	 public List<Category> getCategorys(){
		   return StreamSupport
				   .stream(categoryRepository.findAll().spliterator(), false)
				   .collect(Collectors.toList());
	   }
	   
	 public static Category getCategory(Long id) {
		 return categoryRepository.findById(id).orElseThrow(() ->
		 new CategoryNotFoundException(id));
	 }
	 
	 public Category deleteCategory(Long id) {
		 Category category = getCategory(id);
		 categoryRepository.delete(category);
		   return category;
	   }
	   
	 @Transactional
	   public Category editCategory(Long id, Category category) {
		   Category categoryToEdit = getCategory(id);
		  categoryToEdit.setName(category.getName());
		  return categoryToEdit;
	   }
	   
	 @Transactional
	    public static Category addItemToCategory(Long categoryId, Long itemId) {
	    	Category category = getCategory(categoryId);
	    	Item item = itemService.getItem(itemId);
	    	if(Objects.nonNull(item.getCategory())) {
	    		throw new ItemIsAlreadyAssignedException(itemId, item.getCategory().getId());
	    	}
	    	category.addItem(item);
	    	return category;
	    }
	    
	 @Transactional
	    public static Category removeItemFromCategory(Long categoryId, Long itemId) {
	    	Category category = getCategory(categoryId);
	    	Item item = itemService.getItem(itemId);
	    	category.removeItem(item);
	    	return category;
	    }
}
