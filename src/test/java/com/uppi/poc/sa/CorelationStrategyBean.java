package com.uppi.poc.sa;

import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

public class CorelationStrategyBean implements CorrelationStrategy,ReleaseStrategy  {

	@Override
	public Object getCorrelationKey(Message<?> message) {
		BaseEvent event=(BaseEvent)message.getPayload();
		return event.getFpAccountId();
	}

	@Override
	public boolean canRelease(MessageGroup group) {
		System.out.println("Group :"+group.getGroupId());
		return group.getMessages().size()>2;
		
	}
}
