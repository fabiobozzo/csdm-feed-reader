package com.csdm.reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FeedReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedReaderApplication.class, args);
	}

}
