package com.csdm.reader.parser;

import java.util.List;

import org.springframework.stereotype.Component;

import com.csdm.reader.model.FeedEntry;

@Component("xmlFeedParser")
public class XMLFeedParser implements FeedParser {

	@Override
	public List<FeedEntry> parse(String feedContent) {
		
		return null;
	}
}
