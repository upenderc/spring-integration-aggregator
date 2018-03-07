package com.uppi.poc.sa;

public class EventC extends BaseEvent {

	@Override
	public String toString() {
		return "EventC [eventName=" + eventName + ", fpAccountId=" + fpAccountId + ", programId=" + programId + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getOrder() {
		return 2;
	}

}
