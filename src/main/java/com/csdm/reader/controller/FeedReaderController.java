package com.csdm.reader.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csdm.reader.model.FeedEntry;
import com.csdm.reader.service.FeedEntryService;

@RestController
public class FeedReaderController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedEntryService feedEntryService;

	@RequestMapping("/list")
    public List<FeedEntry> listFeedEntries() {
        
		try {
		
        	return feedEntryService.listFeedEntries();
		
        } catch (Exception e) {
        	logger.warn(e.toString());
			return new ArrayList<>();
		}
    }
}
