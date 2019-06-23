package com.csdm.reader.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testParseRssDate() {
		Date parsedDate = DateUtil.parseRssDate("Sat, 22 Jun 2019 00:00:01 +0200");
		assertNotNull(parsedDate);
		assertEquals("Sat Jun 22 00:00:01 CEST 2019",parsedDate.toString());
	}
}
