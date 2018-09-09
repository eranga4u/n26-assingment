package com.n26.stat.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.n26.exception.FutureTransactionException;
import com.n26.exception.TransactionExpiredException;
import com.n26.stat.domain.Statistic;
import com.n26.stat.domain.Transaction;
import com.n26.stat.dto.StatisticDTO;
import com.n26.stat.dto.TransactionDTO;
import com.n26.stat.service.StatisticService;
import com.n26.stat.util.DateUtil;

@Service
public class StatisticServiceImpl implements StatisticService {

	private Map<String, Statistic> statisticHistory;

	private Map<Long, Transaction> transactionHistory;

	public StatisticServiceImpl() {
		this.statisticHistory = new ConcurrentHashMap<String, Statistic>();
		this.transactionHistory = new ConcurrentHashMap<Long, Transaction>();

	}

	@Override
	public void addTransaction(TransactionDTO transactionDto) throws TransactionExpiredException, FutureTransactionException {

		Calendar timeNow = Calendar.getInstance();
		
		Long trnTimestamp = DateUtil.converToTimeStamp(transactionDto.getDate());

		Long currentTimestamp = timeNow.getTimeInMillis();
		
		
		timeNow.add(Calendar.SECOND, 60);

		Long sixTSecTimestamp = timeNow.getTimeInMillis();
		
		if(currentTimestamp<=trnTimestamp) {
			throw new TransactionExpiredException();
			
		}
		
		if(sixTSecTimestamp<trnTimestamp) {
			throw new FutureTransactionException();
		  
		}
		

		transactionHistory.put(currentTimestamp, transactionTransform(transactionDto));

	}

	private Transaction transactionTransform(TransactionDTO transactionDto) {
		Transaction transaction = new Transaction();

		transaction.setAmount(transactionDto.getAmount());
		transaction.setDate(transactionDto.getDate());

		return transaction;

	}

	@Override
	public StatisticDTO findStatistic(final int timeTraveltime) {

		Double sum = 0.0;

		int count = 0;

		double[] amt = new double[transactionHistory.size()];

		for (Map.Entry<Long, Transaction> entry : transactionHistory.entrySet()) {
			Long timestamp = entry.getKey();
			Transaction value = entry.getValue();

			Calendar timeNow = Calendar.getInstance();
			timeNow.add(Calendar.SECOND, timeTraveltime);

			Long beforSixTSecTimestamp = timeNow.getTimeInMillis();

			if (beforSixTSecTimestamp < timestamp) {

				System.out.println(value.getAmount());

				sum += value.getAmount();

				amt[count] = value.getAmount();
				count++;

			}

		}

		OptionalDouble max = Arrays.stream(amt).max();
		OptionalDouble min = Arrays.stream(amt).min();


		StatisticDTO statistic = new StatisticDTO();

		statistic.setSum(sum);
		statistic.setAvg(sum / count);
		statistic.setCount(count);
		statistic.setMax(max.isPresent() ? max.getAsDouble() : 0);
		statistic.setMin(min.isPresent() ? min.getAsDouble() : 0);

		return statistic;

	}

	@Override
	public void delete() {
		this.statisticHistory.clear();

	}

}
