package com.n26.stat.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.exception.FutureTransactionException;
import com.n26.exception.TransactionExpiredException;
import com.n26.stat.dto.TransactionDTO;
import com.n26.stat.service.TransactionService;

/**
 * 
 * 
 * @author Eranga Kodikara
 *
 */

@RestController
@RequestMapping("/")
public class TransactionsController {

	//private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsController.class);

	@Autowired
	private TransactionService transactionService;

	@PostMapping(value = "transactions", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void addTransactions(@RequestBody @Validated TransactionDTO transaction) throws TransactionExpiredException, FutureTransactionException {

		transactionService.add(transaction);

	}

	@DeleteMapping(value = "transactions")
	public ResponseEntity<Object> deleteTransactions() {
		
		transactionService.delete();
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
