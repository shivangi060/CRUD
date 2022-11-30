package com.codefor.onetomany.model.dto;

import java.util.*;
import java.util.stream.Collectors;

import com.codefor.onetomany.model.Category;
import com.codefor.onetomany.model.Item;

import lombok.Data;

@Data
public class CategoryDto {
   
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	private List<ItemDto> itemsDto = new ArrayList<>();
	
	public static CategoryDto from(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setItemsDto(category.getItems().stream().map(ItemDto::from).collect(Collectors.toList()));
		return categoryDto;
	}
}
