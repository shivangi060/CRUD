package com.codefor.onetomany.model.dto;

import com.codefor.onetomany.model.Category;

import lombok.Data;

@Data
public class PlainCategoryDto {
  private Long id;
  private String name;
  
  public static PlainCategoryDto from(Category category) {
	  PlainCategoryDto plainCategoryDto = new PlainCategoryDto();
	  plainCategoryDto.setId(category.getId());
	  plainCategoryDto.setName(category.getName());
	  return plainCategoryDto;
  }

private void setId(Long id2) {
	// TODO Auto-generated method stub
	
}

private void setName(String name2) {
	// TODO Auto-generated method stub
	
}
}
