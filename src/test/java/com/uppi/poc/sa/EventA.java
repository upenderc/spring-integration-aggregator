package com.uppi.poc.sa;

public class EventA extends BaseEvent {

	@Override
	public String toString() {
		return "EventA [eventName=" + eventName + ", fpAccountId=" + fpAccountId + ", programId=" + programId + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getOrder() {
		return 1;
	}

}
