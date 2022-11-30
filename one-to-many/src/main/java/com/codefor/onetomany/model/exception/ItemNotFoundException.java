package com.codefor.onetomany.model.exception;

import java.text.MessageFormat;
import java.util.regex.Pattern;

import org.apache.logging.log4j.message.Message;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException( final Long id) {
		super(MessageFormat.format("Could Not find item with id:{0}", id));
		
	}

	
	
	
}
