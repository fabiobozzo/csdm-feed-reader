package com.csdm.reader.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csdm.reader.model.FeedEntry;
import com.csdm.reader.service.FeedEntryService;

@RestController
@Api(value="Feed Entries Management System")
public class FeedReaderController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedEntryService feedEntryService;

	@ApiOperation(value="View a list of feed entries", response=List.class)
	@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/list")
    public List<FeedEntry> listFeedEntries() {
        
		try {
		
        	return feedEntryService.listFeedEntries();
		
        } catch (Exception e) {
        	logger.warn(e.toString());
			return new ArrayList<>();
		}
    }
}
