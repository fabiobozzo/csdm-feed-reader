package com.csdm.reader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static Date parseRssDate(String dateString) {
		try {
			return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
