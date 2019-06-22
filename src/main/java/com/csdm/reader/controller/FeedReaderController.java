package com.csdm.reader.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csdm.reader.model.FeedEntry;

@RestController
public class FeedReaderController {

	@RequestMapping("/list")
    public List<FeedEntry> listFeedEntries() {
        return new ArrayList<FeedEntry>();
    }
}
