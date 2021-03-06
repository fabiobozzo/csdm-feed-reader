package com.csdm.reader.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedEntryService feedEntryService;
	
	@Scheduled( fixedDelayString="${feed.schedule.interval}", initialDelay=5000 )
	public void updateFeedEntries() {
		try {
			
			feedEntryService.updateFeedEntries();
			
		} catch(Exception e) {
			logger.error(e.toString());
		}
	}
}
