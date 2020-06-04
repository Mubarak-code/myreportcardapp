package com.recordcard.customermanagementapi.model.status;

public class Response {
	
	private int status;
	private String message;
	private Iterable<?> data;
	
	public Response(int status, String message, Iterable<?> data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Iterable<?> getData() {
		return data;
	}

	public void setData(Iterable<?> data) {
		this.data = data;
	}
	
	
	

}
