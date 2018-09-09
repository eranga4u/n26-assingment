package com.n26.stat.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Transaction DTO
 * 
 * @author eranga
 *
 */

public class Transaction implements Serializable {

	private static final long serialVersionUID = 4849014381144023195L;

	private Double amount;
	private LocalDateTime date;

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
