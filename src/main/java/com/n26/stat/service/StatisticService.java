package com.n26.stat.service;


import com.n26.exception.FutureTransactionException;
import com.n26.exception.TransactionExpiredException;
import com.n26.stat.dto.StatisticDTO;
import com.n26.stat.dto.TransactionDTO;

public interface StatisticService {

	void addTransaction(TransactionDTO transactionDto)throws TransactionExpiredException, FutureTransactionException ;

	void delete();

	StatisticDTO findStatistic(final int timeTraveltime);

}
