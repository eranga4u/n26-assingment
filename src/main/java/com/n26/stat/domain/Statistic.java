package com.n26.stat.domain;

import java.io.Serializable;

/**
 * Statistic domain entity
 * @author eranga
 *
 */

public class Statistic implements Serializable {

	private static final long serialVersionUID = -7828465544148929529L;
	//private LocalDateTime date;
	private Double sum;
	private Double avg;
	private Double max;
	private Double min;
	private Integer count;
	
	/**
	 * @return the sum
	 */
	public Double getSum() {
		return sum;
	}
	/**
	 * @param sum the sum to set
	 */
	public void setSum(Double sum) {
		this.sum = sum;
	}
	/**
	 * @return the avg
	 */
	public Double getAvg() {
		return avg;
	}
	/**
	 * @param avg the avg to set
	 */
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	/**
	 * @return the max
	 */
	public Double getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(Double max) {
		this.max = max;
	}
	/**
	 * @return the min
	 */
	public Double getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(Double min) {
		this.min = min;
	}
	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	

	

}
