package com.n26.stat.exception;

public class InvalidTimestampException extends IllegalArgumentException {
 
	private static final long serialVersionUID = 3533478870571073937L;

	public InvalidTimestampException(String message) {
        super(message);
    }

    public static void check(boolean condition, String message, Object... args) {
        if (!condition) {
            throw new InvalidTimestampException(String.format(message, args));
        }
    }
}
