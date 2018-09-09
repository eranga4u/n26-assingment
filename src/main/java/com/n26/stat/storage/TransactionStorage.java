package com.n26.stat.storage;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public interface TransactionStorage<T> {

	void update(long timestamp, UnaryOperator<T> updater);

	T reduce(BinaryOperator<T> reducer);

}
