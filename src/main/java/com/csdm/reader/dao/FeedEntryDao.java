package com.csdm.reader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csdm.reader.model.FeedEntry;

@Repository
public interface FeedEntryDao extends JpaRepository<FeedEntry, Long> {

	public FeedEntry findByPermalink(String permalink);
	
	public List<FeedEntry> findAllByOrderByPubDateDesc();
}
