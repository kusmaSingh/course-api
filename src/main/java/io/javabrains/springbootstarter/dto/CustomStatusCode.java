package io.javabrains.springbootstarter.dto;
/**
 * 
 */

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Kusma
 *
 *         28-Dec-2017
 */
public class CustomStatusCode {

	public enum customStatuscodes {
		INVALID(401), FAIL(500), OK(200), NULL(505);
		private int statuscode;

		private customStatuscodes(int statuscode) {
			this.statuscode = statuscode;
		}

		@JsonValue
		public int getStatuscode() {
			return statuscode;
		}

	}

	public enum hTTPStatusMessage {
		SUCCESS("SUCCESS"), FAILED("Opps!! There is somthing went worng"), UPDATED("UPDATED"), CREATED("CREATED"), 
		INVALID("Invalid username and Password"), CONFLICT("This User Is already exist");

		private String value;

		private hTTPStatusMessage(String value) {
			this.value = value;

		}

		/**
		 * @return the value
		 */
		public final String getValue() {
			return value;
		}
	}
	
	public enum Authentication {
	    GLOBAL(2),
	    AUTHENTICATION_SUCCESS(700), 
	    AUTHENTICATION_FAILED(701), 
	    BAD_CREDENTIALS(703),
	    AUTHENTICATION_CREDENTIALS_NOT_PROVIDED(704),
	    LOGOUT_SUCCESS(705),
	    AUTH_METHOD_NOT_SUPPORTED(706),
	    INVALID_JWT_TOKEN(710),
	    JWT_TOKEN_EXPIRED(711);
	   
	    
	    private int statusCode;

	    private Authentication(int statusCode) {
	        this.statusCode = statusCode;
	    }

	    @JsonValue
	    public int getStatusCode() {
	        return statusCode;
	    }
	}

}