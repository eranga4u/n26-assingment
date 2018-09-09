package com.n26.stat.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	public static LocalDateTime convertToLocalDateTime(Long timestamp) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
	}

	public static Long converToTimeStamp(LocalDateTime localDateTime) {
		
		return localDateTime.toEpochSecond(ZoneOffset.UTC) * 1000;
	}

	public static Long changeTimeStamp(Date date, Integer seconds) {

		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(date.getTime());
		calender.add(Calendar.SECOND, seconds);
		Date changeDate = calender.getTime();

		return changeDate.getTime();
	}

}
