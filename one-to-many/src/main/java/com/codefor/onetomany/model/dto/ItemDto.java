package com.codefor.onetomany.model.dto;

import java.util.Objects;

import com.codefor.onetomany.model.Item;

import lombok.Data;

@Data
public class ItemDto {

	private Long id;
	private String serialNumber;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	private PlainCategoryDto plainCategoryDto;
	
	public PlainCategoryDto getPlainCategoryDto() {
		return plainCategoryDto;
	}

	public void setPlainCategoryDto(PlainCategoryDto plainCategoryDto) {
		this.plainCategoryDto = plainCategoryDto;
	}

	public static ItemDto from(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(item.getId());
		itemDto.setSerialNumber(item.getSerialNumber());
		if(Objects.nonNull(item.getCategory())) {
			itemDto.setPlainCategoryDto(PlainCategoryDto.from(item.getCategory()));
		}
		return itemDto;
		
	}
	
}
