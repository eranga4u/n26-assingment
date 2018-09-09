package com.n26.stat.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 * Transaction DTO
 * 
 * @author eranga
 *
 */

public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 4849014381144023195L;

	@NotNull(message = "Amount can not be empty")
	private Double amount;
	@NotNull(message = "Amount can not be empty")
	private LocalDateTime date;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
