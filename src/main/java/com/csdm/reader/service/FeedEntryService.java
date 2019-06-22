package com.csdm.reader.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.csdm.reader.dao.FeedEntryDao;
import com.csdm.reader.model.FeedEntry;
import com.csdm.reader.parser.FeedParser;
import com.csdm.reader.util.FeedRetriever;

@Service
public class FeedEntryService {
	
	@Autowired
	Environment env;
	
	@Autowired
	FeedEntryDao feedEntryDao;
	
	@Resource(name="xmlFeedParser")
	FeedParser feedParser;
	
	public void updateFeedEntries() throws Exception {
		
		String feedRawContent = FeedRetriever.retrieveFromURI( env.getProperty("feed.uri") );
		
		List<FeedEntry> feedParsedEntries = feedParser.parse(feedRawContent);
		
		if ( feedParsedEntries==null ) {
			throw new Exception("Can't parse feed content: "+feedRawContent);
		}
		
		for ( FeedEntry fe : feedParsedEntries ) {
			
			if ( feedEntryDao.findByPermalink(fe.getPermalink()) ==null ) {
				feedEntryDao.save(fe);
			}
		}
	}
	
	public List<FeedEntry> listFeedEntries() throws Exception {
		
		Iterable<FeedEntry> findAll = feedEntryDao.findAll();
		List<FeedEntry> feedEntries = new ArrayList<>();
		findAll.forEach(feedEntries::add);
		
		if ( feedEntries.isEmpty() ) {
			throw new Exception("No feed entries found");
		}
		
		return feedEntries; 
	}

	public FeedEntryDao getFeedEntryDao() {
		return feedEntryDao;
	}

	public void setFeedEntryDao(FeedEntryDao feedEntryDao) {
		this.feedEntryDao = feedEntryDao;
	}
	
}
