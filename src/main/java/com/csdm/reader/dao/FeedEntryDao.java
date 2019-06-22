package com.csdm.reader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csdm.reader.model.FeedEntry;

@Repository
public interface FeedEntryDao extends CrudRepository<FeedEntry, Long> {

	public List<FeedEntry> findByPermalink(String permalink);
}
