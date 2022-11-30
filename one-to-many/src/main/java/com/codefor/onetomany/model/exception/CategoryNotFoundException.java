package com.codefor.onetomany.model.exception;

import java.text.MessageFormat;

public class CategoryNotFoundException extends RuntimeException {
	
	public CategoryNotFoundException(final Long id) {
		super(MessageFormat.format("Could Not find Category with id:{0}", id));
		
	}


}
