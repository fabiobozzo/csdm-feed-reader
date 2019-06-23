package com.csdm.reader.parser;

import java.util.List;

import com.csdm.reader.model.FeedEntry;

public interface FeedParser {

	public List<FeedEntry> parse(String feedContent) throws Exception;
	
}
