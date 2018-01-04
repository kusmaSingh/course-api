/**
 * 
 */
package io.javabrains.springbootstarter.dto;

import org.springframework.http.HttpStatus;

/**
 * @author Kusma
 *
 * 28-Dec-2017
 */
public class ResponseDTO {
	private HttpStatus status;

	private int statusCode;

	private Object data;

	private String message = "";
	
	/**
	 * 
	 */
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param status
	 * @param statusCode
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, int statusCode, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
	}



	/**
	 * @param status
	 * @param data
	 */
	public ResponseDTO(HttpStatus status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	/**
	 * @param status
	 * @param statusCode
	 * @param data
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, int statusCode, Object data, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		this.message = message;
	}

	/**
	 * @param status
	 * @param data
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}
	
	
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
