package com.csdm.reader.util;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class FeedRetriever {

	public static String retrieveFromURI(String uri) throws RestClientException {
		RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.getForObject(uri, String.class);
	}
}
