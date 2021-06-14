package com.truemeds.datacleaner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truemeds.datacleaner.service.InputDetailsService;

@RestController
public class DataCleanerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataCleanerController.class);
	@Autowired
	private InputDetailsService ids;

	@GetMapping(value = "/clean")
	public String triggerCleaning() {
		LOGGER.info("/clean URI triggered");
		return ids.cleanResult();
	}
}
