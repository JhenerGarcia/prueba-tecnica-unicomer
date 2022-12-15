package com.unicomer.dto;

public class UnicomerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1465798667170192447L;
	private ApiResult apiResult;

	public UnicomerException(String message) {
		super(message);
	}

	public UnicomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnicomerException(Throwable cause) {
		super(cause);
	}

	public UnicomerException(Throwable cause, ApiResult apiResult) {
		super(cause);
		this.apiResult = apiResult;
	}
	
	public UnicomerException(ApiResult apiResult) {
		super(apiResult.getMessage());
		this.apiResult = apiResult;
	}

	public ApiResult getApiResult() {
		return apiResult;
	}

	public void setApiResult(ApiResult apiResult) {
		this.apiResult = apiResult;
	}

}
