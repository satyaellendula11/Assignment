package com.aerospike.assignment.exception;

public class NotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1102995667358685925L;

	public NotFoundException(String msg) {
        super(msg);
    }
}
