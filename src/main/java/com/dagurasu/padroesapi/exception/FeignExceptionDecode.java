package com.dagurasu.padroesapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeignExceptionDecode extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private final int status;

    public FeignExceptionDecode(int status, String msg) {
        super(msg);
        this.status = status;
    }

    public FeignExceptionDecode(int status) {
    	this.status = status;
    }

	public String getMessageLocal() {
        if (getMessage() == null)
            return "";

        return getMessage().toLowerCase().replaceAll(" ", "_");
    }
}
