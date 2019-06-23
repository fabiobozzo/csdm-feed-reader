package com.csdm.reader.parser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csdm.reader.model.FeedEntry;
import com.csdm.reader.util.DateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlFeedParserTest {

	@Resource(name="xmlFeedParser")
	FeedParser feedParser;
	
	@Test
	public void testParse() throws Exception {
		
		FeedEntry expectedFeedEntry = new FeedEntry(
			null, 
			"titolo", 
			"https://csdm.online", 
			"descrizione", 
			DateUtil.parseRssDate("Sun, 23 Jun 2019 00:00:01 +0200"), 
			"https://bit.ly/2RAhqDW",
			"https://csdm.online/wp-content/uploads/2017/11/csdm_logo_wit_nieuw_klein-01.png"
		);
		
		assertEquals(
			Arrays.asList(expectedFeedEntry), 
			feedParser.parse("<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss version=\"2.0\" xmlns:feedburner=\"http://rssnamespace.org/feedburner/ext/1.0\" xmlns:geo=\"http://www.w3.org/2003/01/geo/wgs84_pos#\" xmlns:itunes=\"http://www.itunes.com/dtds/podcast-1.0.dtd\"><channel><title>feedTitle</title><item><title><![CDATA[titolo]]></title><link>https://csdm.online</link><description>descrizione</description><enclosure length=\"0\" type=\"image/jpeg\" url=\"https://csdm.online/wp-content/uploads/2017/11/csdm_logo_wit_nieuw_klein-01.png\"/><pubDate>Fri, 23 Jun 2019 00:00:01 +0200</pubDate><guid isPermaLink=\"false\">https://bit.ly/2RAhqDW</guid><feedburner:origLink>https://bit.ly/2RAhqDW</feedburner:origLink></item></channel></rss>")
		);
	}

}
