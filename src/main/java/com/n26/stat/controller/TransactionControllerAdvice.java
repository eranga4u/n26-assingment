package com.n26.stat.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.n26.exception.FutureTransactionException;
import com.n26.exception.TransactionExpiredException;
import com.n26.stat.util.ErrorDetails;

@ControllerAdvice
@RestController
public class TransactionControllerAdvice {

	@ExceptionHandler(TransactionExpiredException.class)
	protected ResponseEntity<Object> handleMethodTransactionExpird(TransactionExpiredException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Transaction is older than 60 seconds",
				ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(FutureTransactionException.class)
	protected ResponseEntity<Object> handleMethodFutureTransaction(FutureTransactionException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "The transaction date is in the future",
				ex.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
