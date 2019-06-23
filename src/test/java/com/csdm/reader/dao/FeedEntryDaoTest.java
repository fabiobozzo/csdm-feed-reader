package com.csdm.reader.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.csdm.reader.model.FeedEntry;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringRunner.class)
public class FeedEntryDaoTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private FeedEntryDao feedEntryDao;
	
	@Test
	public void testListFeedEntries() {
		
		persistDummyEntries();
		
		List<FeedEntry> feedEntries = feedEntryDao.findAllByOrderByPubDateDesc();
		
		assertNotNull(feedEntries);
		assertEquals(2, feedEntries.size());
		assertEquals("second", feedEntries.get(0).getTitle());
	}
	
	@Test
	public void tesFindByPermalink() {
		
		persistDummyEntries();
		
		FeedEntry entry = feedEntryDao.findByPermalink("unknown");
		assertNull(entry);
		
		FeedEntry entry1 = feedEntryDao.findByPermalink("permalink1");
		assertNotNull(entry1);
		assertEquals("first", entry1.getTitle());
		
		FeedEntry entry2 = feedEntryDao.findByPermalink("permalink2");
		assertNotNull(entry2);
		assertEquals("second", entry2.getTitle());
	}
	
	private void persistDummyEntries() {
		
		FeedEntry dummy1 = new FeedEntry();
		dummy1.setTitle("first");
		dummy1.setPermalink("permalink1");
		dummy1.setPubDate(new Date(System.currentTimeMillis() - 3600 * 1000));

		FeedEntry dummy2 = new FeedEntry();
		dummy2.setTitle("second");
		dummy2.setPermalink("permalink2");
		dummy2.setPubDate(new Date());
		
		entityManager.merge(dummy1);
		entityManager.merge(dummy2);
	}
}
