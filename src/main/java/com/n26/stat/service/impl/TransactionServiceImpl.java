package com.n26.stat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.exception.FutureTransactionException;
import com.n26.exception.TransactionExpiredException;
import com.n26.stat.dto.TransactionDTO;
import com.n26.stat.service.StatisticService;
import com.n26.stat.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private StatisticService statisticService;

	@Override
	public void add(TransactionDTO transactionDto) throws TransactionExpiredException, FutureTransactionException  {

		statisticService.addTransaction(transactionDto);

	}

	@Override
	public void delete() {

		statisticService.delete();
	}

}
