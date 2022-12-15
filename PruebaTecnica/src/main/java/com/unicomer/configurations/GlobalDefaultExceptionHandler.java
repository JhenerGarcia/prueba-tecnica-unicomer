package com.unicomer.configurations;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.unicomer.dto.ApiData;
import com.unicomer.dto.ApiResult;
import com.unicomer.dto.UnicomerException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler({ UnicomerException.class, Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiResult resolveException(Exception ex) {
		log.error("Exception", ex);
		if (ex instanceof UnicomerException)
			return ((UnicomerException) ex).getApiResult();
		return new ApiResult("999", "Internal Server Error", LocalDateTime.now(),
				new ApiData("Exception", ex.getMessage()));
	}

}
