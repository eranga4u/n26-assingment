package com.n26.stat.service;


import com.n26.exception.FutureTransactionException;
import com.n26.exception.TransactionExpiredException;
import com.n26.stat.dto.TransactionDTO;

public interface TransactionService {

	public void add(TransactionDTO transactionDto) throws TransactionExpiredException, FutureTransactionException;

	public void delete();
}
