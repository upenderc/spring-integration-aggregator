package com.uppi.poc.sa;

import java.util.List;

import org.apache.log4j.Logger;

public class Consumer {
	private static final Logger LOG = Logger.getLogger(Consumer.class);
	public void onMessage(List<BaseEvent> message) {
		LOG.info("Received Batch >>> "+message);
	}
}
