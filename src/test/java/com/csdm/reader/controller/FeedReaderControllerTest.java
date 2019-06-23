package com.csdm.reader.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.csdm.reader.model.FeedEntry;
import com.csdm.reader.service.FeedEntryService;

@RunWith(SpringRunner.class)
@WebMvcTest(FeedReaderController.class)
public class FeedReaderControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private FeedEntryService feedEntryService;

	@Before
	public void setup() throws Exception {

		FeedEntry dummy1 = new FeedEntry();
		dummy1.setId(1l);
		dummy1.setTitle("first");
		dummy1.setPubDate(new Date());

		FeedEntry dummy2 = new FeedEntry();
		dummy2.setId(2l);
		dummy2.setTitle("second");
		dummy2.setPubDate(new Date(System.currentTimeMillis() - 3600 * 1000));

		List<FeedEntry> dummyEntries = Arrays.asList(dummy1, dummy2);

		Mockito.when(feedEntryService.listFeedEntries()).thenReturn(dummyEntries);
	}

	@Test
	public void testListFeedEntries() throws Exception {
		
		mvc.perform(
			get("/list")
		      .contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk())
		      .andExpect(jsonPath("$", hasSize(2)))
		      .andExpect(jsonPath("$[0].title", is("first")));
	}

}
