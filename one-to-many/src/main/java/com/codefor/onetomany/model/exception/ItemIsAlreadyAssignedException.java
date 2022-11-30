package com.codefor.onetomany.model.exception;

import java.text.MessageFormat;

import org.apache.logging.log4j.message.Message;

public class ItemIsAlreadyAssignedException extends RuntimeException {
	
	public ItemIsAlreadyAssignedException(final Long itemId, final Long categotyId) {
		super(MessageFormat.format("Item: {0} is already assigned to category:{1}", itemId, categotyId));
	}

}
