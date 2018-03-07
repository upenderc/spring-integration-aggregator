package com.uppi.poc.sa;

public class EventB extends BaseEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getOrder() {
		
		return 3;
	}

	@Override
	public String toString() {
		return "EventB [eventName=" + eventName + ", fpAccountId=" + fpAccountId + ", programId=" + programId + "]";
	}

	
}
